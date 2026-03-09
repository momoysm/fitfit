package com.ecommerce.member.repository;

import static com.ecommerce.member.entity.QMember.member;

import com.ecommerce.member.entity.Member;
import com.ecommerce.member.entity.MemberStatus;
import com.ecommerce.member.entity.MemberType;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Member> searchMembers(
        LocalDate startDate,
        LocalDate endDate,
        String searchType,
        String searchText,
        MemberType type,
        MemberStatus status,
        Pageable pageable
    ) {
        // 1. 실제 데이터 조회 쿼리
        List<Member> content = jpaQueryFactory
            .selectFrom(member)
            .where(
                dateBetween(startDate, endDate),
                searchKeywordEq(searchType, searchText),
                typeEq(type),
                statusEq(status)
            )
            .offset(pageable.getOffset()) // 페이지 시작 지점
            .limit(pageable.getPageSize()) // 페이지 당 개수
            .orderBy(getOrderSpecifiers(pageable.getSort()))
            .fetch();

        // 2. 전체 개수 조회 쿼리 (페이징 계산용)
        JPAQuery<Long> countQuery = jpaQueryFactory
            .select(member.count())
            .from(member)
            .where(
                dateBetween(startDate, endDate),
                searchKeywordEq(searchType, searchText),
                typeEq(type),
                statusEq(status)
            );

        // 3. Page 객체 반환 (PageableExecutionUtils를 쓰면 카운트 쿼리 최적화가 가능합니다)
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    // --- 동적 조건 필터 메서드들 ---

    private BooleanExpression dateBetween(LocalDate start, LocalDate end) {
        if (start == null && end == null) {
            return null;
        }
        if (start != null && end == null) {
            return member.createdAt.goe(start.atStartOfDay());
        }
        if (start == null && end != null) {
            return member.createdAt.loe(end.atTime(LocalTime.MAX));
        }
        return member.createdAt.between(start.atStartOfDay(), end.atTime(LocalTime.MAX));
    }

    private BooleanExpression searchKeywordEq(String searchType, String searchText) {
        if (!StringUtils.hasText(searchText)) {
            return null;
        }

        return switch (searchType) {
            case "email" -> member.email.containsIgnoreCase(searchText);
            case "name" -> member.name.containsIgnoreCase(searchText);
            case "phone" -> member.phone.containsIgnoreCase(searchText);
            // '전체' 선택 시 이메일, 이름, 전화번호 중 하나라도 포함되면 검색
            default -> member.email.containsIgnoreCase(searchText)
                .or(member.name.containsIgnoreCase(searchText))
                .or(member.phone.containsIgnoreCase(searchText));
        };
    }

    private BooleanExpression typeEq(MemberType type) {
        return type != null ? member.type.eq(type) : null;
    }

    private BooleanExpression statusEq(MemberStatus status) {
        return status != null ? member.status.eq(status) : null;
    }

    private OrderSpecifier<?>[] getOrderSpecifiers(Sort sort) {
        return sort.stream()
            .map(order -> {
                Order direction = order.isAscending() ? Order.ASC : Order.DESC;
                // member 엔티티의 경로를 동적으로 생성
                PathBuilder<Member> pathBuilder = new PathBuilder<>(
                    member.getType(),
                    member.getMetadata()
                );
                return new OrderSpecifier<>(
                    direction,
                    pathBuilder.getComparable(order.getProperty(), Comparable.class)
                );
            })
            .toArray(OrderSpecifier[]::new);
    }
}
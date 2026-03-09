package com.ecommerce.member.repository;

import com.ecommerce.member.entity.Member;
import com.ecommerce.member.entity.MemberStatus;
import com.ecommerce.member.entity.MemberType;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberQueryRepository {

    Page<Member> searchMembers(
        LocalDate startDate,
        LocalDate endDate,
        String searchType,
        String searchText,
        MemberType type,
        MemberStatus status,
        Pageable pageable
    );
}

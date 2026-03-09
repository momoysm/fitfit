package com.ecommerce.admin.member.service;

import com.ecommerce.admin.member.converter.MemberDtoConverter;
import com.ecommerce.admin.member.dto.MemberListSearchCondition;
import com.ecommerce.admin.member.dto.MemberResponse;
import com.ecommerce.common.dto.PageResponse;
import com.ecommerce.member.entity.Member;
import com.ecommerce.member.entity.MemberStatus;
import com.ecommerce.member.exception.MemberNotFoundException;
import com.ecommerce.member.repository.MemberQueryRepository;
import com.ecommerce.member.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j(topic = "MemberService")
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberDtoConverter memberDtoConverter;
    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;

    // Member Page 조회
    public PageResponse<MemberResponse> getMembers(
        MemberListSearchCondition condition,
        Pageable pageable
    ) {
        Page<Member> memberPage = memberQueryRepository.searchMembers(
            condition.startDate(),
            condition.endDate(),
            condition.searchType(),
            condition.searchText(),
            condition.type(),
            condition.status(),
            pageable
        );

        List<MemberResponse> dtoList = memberPage.getContent().stream()
            .map(memberDtoConverter::toResponse)
            .toList();

        return PageResponse.of(memberPage, dtoList);
    }

    // Member 단건 조회
    public MemberResponse getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException(memberId));

        return memberDtoConverter.toResponse(member);
    }

    @Transactional
    public MemberResponse updateMember(
        Long memberId,
        String name,
        String phone,
        MemberStatus status
    ) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException(memberId));

        // 값이 존재할 때만 엔티티 상태 변경
        if (name != null && !name.trim().isEmpty()) {
            member.updateName(name);
        }

        if (phone != null && !phone.trim().isEmpty()) {
            member.updatePhone(phone);
        }

        if (status != null) {
            member.updateStatus(status);
        }

        return memberDtoConverter.toResponse(member);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException(memberId));

        memberRepository.delete(member);
    }
}

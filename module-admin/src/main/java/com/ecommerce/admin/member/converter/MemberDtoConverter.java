package com.ecommerce.admin.member.converter;

import com.ecommerce.admin.member.dto.MemberResponse;
import com.ecommerce.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberDtoConverter {

    public MemberResponse toResponse(Member member) {
        if (member == null) {
            return null;
        }

        return MemberResponse.of(
            member.getId(),
            member.getEmail(),
            member.getName(),
            member.getPhone(),
            member.getType(),
            member.getStatus(),
            member.getLastLoginAt(),
            member.getCreatedAt()
        );
    }

}

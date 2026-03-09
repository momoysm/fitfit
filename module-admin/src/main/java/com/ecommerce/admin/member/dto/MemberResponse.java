package com.ecommerce.admin.member.dto;

import com.ecommerce.member.entity.MemberStatus;
import com.ecommerce.member.entity.MemberType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberResponse(
    Long memberId,
    String email,
    String name,
    String phone,
    MemberType type,
    MemberStatus status,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime lastLoginAt,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdAt
) {

    public static MemberResponse of(
        Long memberId
        , String email
        , String name
        , String phone
        , MemberType type
        , MemberStatus status
        , LocalDateTime lastLoginAt
        , LocalDateTime createdAt
    ) {
        return MemberResponse.builder()
            .memberId(memberId)
            .email(email)
            .name(name)
            .phone(phone)
            .type(type)
            .status(status)
            .lastLoginAt(lastLoginAt)
            .createdAt(createdAt)
            .build();
    }
}

package com.ecommerce.admin.auth.dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record SignUpResponse(
    Long memberId,
    String email,
    String name,
    LocalDateTime createdAt
) {

    public static SignUpResponse of(
        Long memberId
        , String email
        , String name
        , LocalDateTime createdAt
    ) {
        return SignUpResponse.builder()
            .memberId(memberId)
            .email(email)
            .name(name)
            .createdAt(createdAt)
            .build();
    }
}

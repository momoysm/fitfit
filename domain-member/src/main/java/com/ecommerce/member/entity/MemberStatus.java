package com.ecommerce.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {
    ACTIVE("ACTIVE"), // 활성화
    INACTIVE("INACTIVE"), // 비활성화
    SUSPENDED("SUSPENDED"), // 차단
    ;

    private final String value;

}

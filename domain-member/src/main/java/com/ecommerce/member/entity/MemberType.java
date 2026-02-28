package com.ecommerce.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberType {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    private final String value;

}

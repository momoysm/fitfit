package com.ecommerce.payment.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RefundStatus {
    REQUESTED("REQUESTED"), // 요청
    COMPLETED("COMPLETED"), // 완료
    REJECTED("REJECTED"), // 거절
    ;

    private final String value;
}

package com.ecommerce.order.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderProductStatus {
    PREPARING("PREPARING"), // 준비중
    SHIPPING("SHIPPING"),   // 배송중
    DELIVERED("DELIVERED"), // 배송완료
    CANCELLED("CANCELLED"), // 취소
    REFUNDED("REFUNDED"),   // 환불
    ;
    private final String value;
}

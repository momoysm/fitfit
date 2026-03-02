package com.ecommerce.promotion.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponType {
    FIXED("FIXED"),   // 정액 할인
    RATE("RATE"),     // 정률 할인
    FREE_SHIPPING("FREE_SHIPPING"); // 배송비 무료
    ;
    private final String value;
}

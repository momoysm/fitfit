package com.ecommerce.promotion.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberCouponStatus {
    AVAILABLE("AVAILABLE"), // 사용 가능
    USED("USED"), // 사용 완료
    EXPIRED("EXPIRED"), // 기간 만료
    ;
    private final String value;
}

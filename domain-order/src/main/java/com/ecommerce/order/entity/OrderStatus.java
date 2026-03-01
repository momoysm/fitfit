package com.ecommerce.order.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PENDING("PENDING"),       // 주문 대기 (결제 전)
    PAID("PAID"),             // 결제 완료
    PREPARING("PREPARING"),   // 상품 준비 중
    SHIPPING("SHIPPING"),     // 배송 중
    DELIVERED("DELIVERED"),   // 배송 완료
    CANCELLED("CANCELLED"),   // 주문 취소
    REFUNDED("REFUNDED"),     // 환불 완료
    ;

    private final String value;
}

package com.ecommerce.delivery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeliveryStatus {
    READY("READY"), // 준비중
    PICKED_UP("PICKED_UP"), // 배송사 인수 완료
    IN_TRANSIT("IN_TRANSIT"), // 배송중 (허브 간 이동)
    OUT_FOR_DELIVERY("OUT_FOR_DELIVERY"),// 배송 출발 (오늘 도착 예정)
    DELIVERED("DELIVERED"), // 배송 완료
    ;

    private final String value;
}

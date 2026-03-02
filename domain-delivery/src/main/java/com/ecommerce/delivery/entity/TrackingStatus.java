package com.ecommerce.delivery.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrackingStatus {
    READY("READY"), // 배송 준비중
    PICKED_UP("PICKED_UP"), // 배송사 인수
    IN_TRANSIT("IN_TRANSIT"), // 배송중
    ARRIVED_AT_HUB("ARRIVED_AT_HUB"), // 물류센터 도착
    OUT_FOR_DELIVERY("OUT_FOR_DELIVERY"), // 배송 출발
    DELIVERED("DELIVERED"), // 배송 완료
    DELIVERY_FAILED("DELIVERY_FAILED"), // 배송 실패
    RETURNED("RETURNED"), // 반송 완료
    ;

    private final String value;
}
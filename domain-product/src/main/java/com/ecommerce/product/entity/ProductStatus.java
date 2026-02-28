package com.ecommerce.product.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {
    SELLING("SELLING"), // 판매중
    HIDDEN("HIDDEN"), // 판매 중단
    SOLD_OUI("SOLD_OUI"), // 품절
    ;

    private final String value;
}

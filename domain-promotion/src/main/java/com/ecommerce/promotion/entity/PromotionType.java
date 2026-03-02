package com.ecommerce.promotion.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PromotionType {
    DISCOUNT("DISCOUNT"), // 금액/율 할인
    BOGO("BOGO"), // Buy One Get One (1+1)
    GIFT("GIFT"), // 사은품 증정
    FREE_SHIPPING("FREE_SHIPPING"), // 무료배송
    ;
    private final String value;
}

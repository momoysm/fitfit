package com.ecommerce.promotion.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "coupons")
@Comment("쿠폰")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    @Comment("쿠폰 ID")
    private Long id;

    @Column(name = "coupon_name", nullable = false, length = 255)
    @Comment("쿠폰 이름")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    @Comment("쿠폰 타입")
    private CouponType type;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "discount_value", nullable = false)
    @ColumnDefault("0")
    @Comment("할인 값 (FIXED 또는 FREE_SHIPPING이면 금액, RATE면 %로 취급)")
    private int discountValue;

    @Column(name = "min_order_price", nullable = false)
    @ColumnDefault("0")
    @Comment("최소 주문 금액")
    private int minOrderPrice;

    @Column(name = "max_discount_price")
    @Comment("최대 할인 금액")
    private int maxDiscountPrice;

    @Column(name = "total_quantity")
    @Comment("쿠폰 발급 가능 수량 (null일 경우 무제한)")
    private int totalQuantity;

    @Column(name = "issued_quantity", nullable = false)
    @ColumnDefault("0")
    @Comment("발급된 쿠폰 수량")
    private int issuedQuantity;

    @Column(name = "started_at", nullable = false)
    @Comment("쿠폰 발급 시작 시간")
    private LocalDateTime startedAt;

    @Column(name = "expired_at", nullable = false)
    @Comment("쿠폰 만료 시간")
    private LocalDateTime expiredAt;

    @Column(name = "is_active", nullable = false)
    @ColumnDefault("true")
    @Comment("쿠폰 활성화 여부")
    private boolean isActive;

    @Builder(access = AccessLevel.PRIVATE)
    private Coupon(
        String name
        , CouponType type
        , String description
        , int discountValue
        , int minOrderPrice
        , int maxDiscountPrice
        , int totalQuantity
        , int issuedQuantity
        , LocalDateTime startedAt
        , LocalDateTime expiredAt
        , boolean isActive
    ) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.discountValue = discountValue;
        this.minOrderPrice = minOrderPrice;
        this.maxDiscountPrice = maxDiscountPrice;
        this.totalQuantity = totalQuantity;
        this.issuedQuantity = issuedQuantity;
        this.startedAt = startedAt;
        this.expiredAt = expiredAt;
        this.isActive = isActive;
    }
}

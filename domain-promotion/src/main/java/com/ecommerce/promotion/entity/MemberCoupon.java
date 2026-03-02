package com.ecommerce.promotion.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "member_coupons")
@Comment("회원 쿠폰")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCoupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_coupon_id")
    @Comment("쿠폰 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "coupon_id", nullable = false)
    @Comment("쿠폰 ID")
    private Long couponId;

    @Column(name = "order_id")
    @Comment("주문 ID")
    private Long orderId;

    @Column(name = "status", nullable = false)
    @Comment("쿠폰 상태")
    private MemberCouponStatus status;

    @Column(name = "issued_at", nullable = false)
    @Comment("발급 일시")
    private LocalDateTime issuedAt;

    @Column(name = "used_at")
    @Comment("사용 일시")
    private LocalDateTime usedAt;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberCoupon(
        Long memberId
        , Long couponId
        , LocalDateTime issuedAt
    ) {
        this.memberId = memberId;
        this.couponId = couponId;
        this.status = MemberCouponStatus.AVAILABLE; // 기본값
        this.issuedAt = issuedAt;
    }
}

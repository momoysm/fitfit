package com.ecommerce.payment.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "refunds")
@Comment("환불")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Refund extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refund_id")
    @Comment("환불 ID")
    private Long id;

    @Column(name = "payment_id", nullable = false)
    @Comment("결제 ID")
    private Long paymentId;

    @Column(name = "order_product_id")
    @Comment("주문 상품 ID")
    private Long orderProductId; // null이 아니면 부분 환불

    @Column(name = "pg_refund_id")
    @Comment("PG 환불 ID")
    private String pgRefundId;

    @Column(name = "amount", nullable = false)
    @Comment("환불 금액")
    private int amount;

    @Column(name = "reason", columnDefinition = "TEXT")
    @Comment("환불 사유")
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Comment("환불 상태")
    private RefundStatus status;

    @Column(name = "refunded_at", nullable = false)
    @Comment("환불 일시")
    private String refundedAt;

}

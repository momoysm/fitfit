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
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "payments")
@Comment("결제")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    @Comment("결제 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "order_id", nullable = false)
    @Comment("주문 ID")
    private Long orderId;

    @Column(name = "payment_number", nullable = false, length = 255)
    @Comment("결제 번호")
    private String paymentNumber;

    @Column(name = "pg_transaction_id", nullable = false, length = 255)
    @Comment("PG 트랜잭션 ID")
    private String pgTransactionId;

    @Column(name = "payment_method", nullable = false, length = 255)
    @Comment("결제 수단")
    private String paymentMethod;

    @Column(name = "amount", nullable = false)
    @Comment("결제 금액")
    private int amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Comment("결제 상태")
    private PaymentStatus status;

    @Column(name = "paid_at", nullable = false)
    @Comment("결제 일시")
    private LocalDateTime paidAt;

}

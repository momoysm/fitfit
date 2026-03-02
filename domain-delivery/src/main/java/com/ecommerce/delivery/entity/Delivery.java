package com.ecommerce.delivery.entity;

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
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "deliveries")
@Comment("배송")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    @Comment("배송 ID")
    private Long id;

    @Column(name = "order_id", nullable = false)
    @Comment("주문 ID")
    private Long orderId;

    @Column(name = "courier", nullable = false, length = 255)
    @Comment("택배사")
    private String courier;

    @Column(name = "tracking_number", nullable = false, length = 50, unique = true)
    @Comment("운송장번호")
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Comment("배송상태")
    private DeliveryStatus status;

    @Column(name = "shipped_at")
    @Comment("선박운송일시")
    private LocalDateTime shippedAt;

    @Column(name = "delivered_at")
    @Comment("배송완료일시")
    private LocalDateTime deliveredAt;

    @Builder(access = AccessLevel.PRIVATE)
    private Delivery(
        Long orderId
        , String courier
        , String trackingNumber
    ) {
        this.orderId = orderId;
        this.courier = courier;
        this.trackingNumber = trackingNumber;
        this.status = DeliveryStatus.READY; // 최초 생성 시 READY로
    }
}

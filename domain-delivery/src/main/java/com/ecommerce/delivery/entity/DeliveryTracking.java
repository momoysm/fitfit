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
@Table(name = "delivery_tracking")
@Comment("배송 트래킹")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeliveryTracking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    @Comment("배송 트래킹 ID")
    private Long id;

    @Column(name = "delivery_id", nullable = false)
    @Comment("배송 ID")
    private Long deliveryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Comment("트래킹 상태")
    private TrackingStatus status;

    @Column(name = "location", nullable = false, length = 100)
    @Comment("장소")
    private String location;

    @Column(name = "tracked_at")
    @Comment("트래킹일시")
    private LocalDateTime trackedAt;

    @Builder(access = AccessLevel.PRIVATE)
    private DeliveryTracking(
        Long deliveryId
        , String location
    ) {
        this.deliveryId = deliveryId;
        this.status = TrackingStatus.READY; // 최초 생성 시 READY로
        this.location = location;
    }
}

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
@Table(name = "promotions")
@Comment("프로모션")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Promotion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    @Comment("프로모션 ID")
    private Long id;

    @Column(name = "promotion_name", nullable = false, length = 255)
    @Comment("프로모션 이름")
    private String name;

    @Column(name = "promotion_type", nullable = false)
    @Comment("프로모션 타입")
    private PromotionType type;

    @Column(name = "description", columnDefinition = "TEXT")
    @Comment("프로모션 설명")
    private String description;

    @Column(name = "discount_value")
    @Comment("할인 값 (DISCOUNT일 경우)")
    private int discountValue;

    @Column(name = "started_at", nullable = false)
    @Comment("프로모션 시작일")
    private LocalDateTime startedAt;

    @Column(name = "expired_at", nullable = false)
    @Comment("프로모션 종료일")
    private LocalDateTime expiredAt;

    @Column(name = "is_active", nullable = false)
    @Comment("프로모션 활성화 여부")
    private boolean isActive;

    @Builder(access = AccessLevel.PRIVATE)
    private Promotion(
        String name
        , PromotionType type
        , String description
        , int discountValue
        , LocalDateTime startedAt
        , LocalDateTime expiredAt
        , boolean isActive
    ) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.discountValue = discountValue;
        this.startedAt = startedAt;
        this.expiredAt = expiredAt;
        this.isActive = isActive;
    }
}

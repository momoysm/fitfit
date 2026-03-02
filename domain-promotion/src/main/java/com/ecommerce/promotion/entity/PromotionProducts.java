package com.ecommerce.promotion.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "promotion_products")
@Comment("프로모션_상품")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromotionProducts extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_product_id")
    @Comment("프로모션 상품 ID")
    private Long id;

    @Column(name = "promotion_id", nullable = false)
    @Comment("프로모션 ID")
    private Long promotionId;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Builder(access = AccessLevel.PRIVATE)
    private PromotionProducts(
        Long promotionId
        , Long productId
    ) {
        this.promotionId = promotionId;
        this.productId = productId;
    }
}

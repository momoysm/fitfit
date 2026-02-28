package com.ecommerce.product.entity;

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
@Table(name = "product_variants")
@Comment("변형 상품")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductVariant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    @Comment("상품 변형 ID")
    private Long Id;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "first_option_id")
    @Comment("첫 번째 옵션 ID")
    private Long firstOptionId;

    @Column(name = "second_option_id")
    @Comment("두 번째 옵션 ID")
    private Long secondOptionId;

    @Column(name = "additional_price", nullable = false)
    @Comment("추가 가격")
    private int additionalPrice;

    @Column(name = "stock", nullable = false)
    @Comment("재고 수량")
    private Long stock;

    @Column(name = "sku", length = 100)
    @Comment("재고 관리 코드")
    private String sku;

    @Column(name = "is_active", nullable = false)
    @Comment("활성화 여부")
    private boolean isActive;

    @Builder(access = AccessLevel.PRIVATE)
    private ProductVariant(
        Long productId
        , Long firstOptionId
        , Long secondOptionId
        , int additionalPrice
        , Long stock
        , String sku
    ) {
        this.productId = productId;
        this.firstOptionId = firstOptionId;
        this.secondOptionId = secondOptionId;
        this.additionalPrice = additionalPrice;
        this.stock = stock;
        this.sku = sku;
        this.isActive = false;
    }
}

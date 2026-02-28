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
@Table(name = "product_images")
@Comment("상품 이미지")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    @Comment("상품 이미지 ID")
    private Long id;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "image_url", nullable = false, length = 500)
    @Comment("이미지 URL")
    private String imageUrl;

    @Column(name = "is_thumbnail", nullable = false)
    @Comment("썸네일 여부")
    private boolean isThumbnail;

    @Column(name = "sort_order", nullable = false)
    @Comment("정렬 순서")
    private int sortOrder;

    @Builder(access = AccessLevel.PRIVATE)
    private ProductImage(
        Long productId
        , String imageUrl
        , boolean isThumbnail
        , int sortOrder
    ) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.isThumbnail = isThumbnail;
        this.sortOrder = sortOrder;
    }
}

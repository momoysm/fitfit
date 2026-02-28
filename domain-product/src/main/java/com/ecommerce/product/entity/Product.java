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
@Table(name = "products")
@Comment("상품")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Comment("상품 ID")
    private Long id;

    @Column(name = "category_id", nullable = false)
    @Comment("상품 카테고리 ID")
    private Long categoryId;

    @Column(name = "name", nullable = false, length = 255)
    @Comment("상품명")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    @Comment("상품 설명")
    private String description;

    @Column(name = "price", nullable = false)
    @Comment("상품 가격")
    private int price;

    @Column(name = "stock", nullable = false)
    @Comment("상품 재고")
    private Long stock;

    @Column(name = "status", nullable = false)
    @Comment("상품 상태")
    private ProductStatus status;

    @Column(name = "has_option", nullable = false)
    @Comment("옵션 여부")
    private boolean hasOption;

    @Column(name = "is_deleted", nullable = false)
    @Comment("삭제 여부")
    private boolean isDeleted;

    @Builder(access = AccessLevel.PRIVATE)
    private Product(
        Long categoryId
        , String name
        , String description
        , int price
        , Long stock
        , ProductStatus status
    ) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.hasOption = false; // default = false
        this.isDeleted = false; // default = false
    }

}

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
@Table(name = "product_option_groups")
@Comment("상품 옵션 그룹")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ProductOptionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_group_id")
    @Comment("상품 옵션 그룹 ID")
    private Long id;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "name", nullable = false, length = 255)
    @Comment("상품 옵션 그룹 이름")
    private String name;

    @Column(name = "sort_order", nullable = false)
    @Comment("상품 옵션 그룹 정렬 순서")
    private int sortOrder;

    @Builder(access = AccessLevel.PRIVATE)
    private ProductOptionGroup(
        Long productId
        , String name
        , int sortOrder
    ) {
        this.productId = productId;
        this.name = name;
        this.sortOrder = sortOrder;
    }
}

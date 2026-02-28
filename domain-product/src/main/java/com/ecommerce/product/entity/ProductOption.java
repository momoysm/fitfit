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
@Table(name = "product_options")
@Comment("상품 옵션")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    @Comment("옵션 ID")
    private Long id;

    @Column(name = "option_group_id", nullable = false)
    @Comment("옵션 그룹 ID")
    private Long optionGroupId;

    @Column(name = "name", nullable = false, length = 255)
    @Comment("옵션 이름")
    private String name;

    @Column(name = "sort_order", nullable = false)
    @Comment("옵션 정렬 순서")
    private int sortOrder;

    @Column(name = "is_active", nullable = false)
    @Comment("옵션 활성화 여부")
    private boolean isActive;

    @Builder(access = AccessLevel.PRIVATE)
    private ProductOption(
        Long optionGroupId
        , String name
        , int sortOrder
        , boolean isActive
    ) {
        this.optionGroupId = optionGroupId;
        this.name = name;
        this.sortOrder = sortOrder;
        this.isActive = isActive;
    }
}

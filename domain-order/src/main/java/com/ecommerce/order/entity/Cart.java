package com.ecommerce.order.entity;

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
@Table(name = "CART")
@Comment("장바구니")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @Comment("장바구니 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "product_variant_id")
    @Comment("상품 변형 ID")
    private Long productVariantId;

    @Column(name = "quantity", nullable = false)
    @Comment("수량")
    private int quantity;

    @Column(name = "is_selected", nullable = false)
    @Comment("선택 여부")
    private boolean isSelected;

    @Builder(access = AccessLevel.PRIVATE)
    private Cart(
        Long memberId
        , Long productId
        , Long productVariantId
        , int quantity,
        boolean isSelected
    ) {
        this.memberId = memberId;
        this.productId = productId;
        this.productVariantId = productVariantId;
        this.quantity = quantity;
        this.isSelected = isSelected;
    }
}

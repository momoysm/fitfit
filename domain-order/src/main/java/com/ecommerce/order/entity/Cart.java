package com.ecommerce.order.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(
    name = "carts",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_member_product_variant",
            columnNames = {"member_id", "product_id", "variant_id"}
        )
    }
)
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

    @Column(name = "variant_id")
    @Comment("상품 변형 ID")
    private Long variantId;

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
        , Long variantId
        , int quantity,
        boolean isSelected
    ) {
        this.memberId = memberId;
        this.productId = productId;
        this.variantId = variantId;
        this.quantity = quantity;
        this.isSelected = isSelected;
    }
}

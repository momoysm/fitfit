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
@Table(name = "order_products")
@Comment("주문 상품")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    @Comment("주문 ID")
    private Long orderId;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 255)
    @Comment("상품명")
    private String productName;

    @Column(name = "option_summary", length = 200)
    @Comment("옵션 정보")
    private String optionSummary;

    @Column(name = "quantity", nullable = false)
    @Comment("수량")
    private int quantity;

    @Column(name = "price", nullable = false)
    @Comment("가격")
    private int price;

    @Column(name = "total_price", nullable = false)
    @Comment("총 가격")
    private int totalPrice;


    @Builder(access = AccessLevel.PRIVATE)
    private OrderProduct(
        Long orderId
        , Long productId
        , String productName
        , String optionSummary
        , int quantity
        , int price
        , int totalPrice
    ) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.optionSummary = optionSummary;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }
}

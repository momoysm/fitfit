package com.ecommerce.order.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
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
@Comment("주문")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Comment("주문 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "total_price", nullable = false)
    @Comment("총 가격")
    private int totalPrice;

    @Column(name = "discount_price", nullable = false)
    @Comment("할인 가격")
    private int discountPrice;

    @Column(name = "final_price", nullable = false)
    @Comment("최종 가격")
    private int finalPrice;

    @Column(name = "status", nullable = false)
    @Comment("주문 상태")
    private OrderStatus status;

    @Column(name = "receiver_name", nullable = false)
    @Comment("수령인 이름")
    private String receiverName;

    @Column(name = "receiver_phone", nullable = false)
    @Comment("수령인 전화번호")
    private String receiverPhone;

    @Column(name = "address_name", nullable = false)
    @Comment("주소")
    private String address;

    @Column(name = "address_detail", nullable = false)
    @Comment("상세 주소")
    private String addressDetail;

    @Column(name = "zip_code", nullable = false)
    @Comment("우편번호")
    private String zipCode;

    @Column(name = "order_request", columnDefinition = "TEXT")
    @Comment("주문 요청사항")
    private String orderRequest;

    @Column(name = "order_at", nullable = false)
    @Comment("주문 일시")
    private LocalDateTime orderAt;

    @Builder(access = AccessLevel.PRIVATE)
    private Order(
        Long memberId
        , int totalPrice
        , int discountPrice
        , int finalPrice
        , String receiverName
        , String receiverPhone
        , String address
        , String addressDetail
        , String zipCode
    ) {
        this.memberId = memberId;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.finalPrice = finalPrice;
        this.status = OrderStatus.PENDING;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.address = address;
        this.addressDetail = addressDetail;
        this.zipCode = zipCode;
        this.orderAt = LocalDateTime.now();
    }
}

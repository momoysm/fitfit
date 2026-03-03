package com.ecommerce.review.entity;

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
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "reviews")
@Comment("리뷰")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    @Comment("리뷰 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "product_id", nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(name = "order_product_id", nullable = false)
    @Comment("주문 상품 ID")
    private Long order_product_id;

    @Column(name = "rating", nullable = false)
    @Comment("리뷰 점수 (1~5)")
    private int rating;

    @Column(name = "content", columnDefinition = "TEXT")
    @Comment("리뷰 내용")
    private String content;

    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("false")
    @Comment("삭제 여부")
    private boolean isDeleted;

    @Builder
    private Review(
        Long memberId
        , Long productId
        , Long order_product_id
        , int rating
        , String content
    ) {
        this.memberId = memberId;
        this.productId = productId;
        this.order_product_id = order_product_id;
        this.rating = rating;
        this.content = content;
    }
}

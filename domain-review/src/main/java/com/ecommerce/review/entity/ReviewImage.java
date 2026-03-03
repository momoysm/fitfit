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
@Table(name = "review_images")
@Comment("리뷰 이미지")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_image_id")
    @Comment("리뷰 이미지 ID")
    private Long id;

    @Column(name = "review_id", nullable = false)
    @Comment("리뷰 ID")
    private Long reviewId;

    @Column(name = "image_url", nullable = false)
    @Comment("이미지 URL")
    private String imageUrl;

    @Column(name = "sort_order", nullable = false)
    @ColumnDefault("0")
    @Comment("정렬 순서")
    private String sortOrder;

    @Builder
    private ReviewImage(
        Long reviewId
        , String imageUrl
        , String sortOrder
    ) {
        this.reviewId = reviewId;
        this.imageUrl = imageUrl;
        this.sortOrder = sortOrder;
    }

}

package com.ecommerce.review.entity;

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
    name = "review_likes",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_review_member",
            columnNames = {"review_id", "member_id"}
        )
    }
)
@Comment("리뷰 좋아요")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Comment("리뷰 좋아요 ID")
    private Long id;

    @Column(name = "review_id", nullable = false)
    @Comment("리뷰 ID")
    private Long reviewId;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Builder
    public ReviewLike(
        Long reviewId
        , Long memberId
    ) {
        this.reviewId = reviewId;
        this.memberId = memberId;
    }
}

package com.ecommerce.product.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "categories")
@Comment("카테고리")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    @Comment("카테고리 ID")
    private Long id;

    @Column(name = "parent_id")
    @Comment("상위 카테고리 ID")
    private Long parentId;

    @Column(name = "name", nullable = false, length = 255)
    @Comment("카테고리 이름")
    private String name;

    @Column(name = "depth", nullable = false)
    @Comment("카테고리 분류")
    private int depth;

    @Column(name = "sort_order", nullable = false)
    @Comment("정렬 순서")
    private int sort_order;

    @Column(name = "is_deleted", nullable = false)
    @Comment("삭제 여부")
    private boolean is_deleted;

}

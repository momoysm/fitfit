package com.ecommerce.member.entity;

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
@Table(name = "member_password_histories")
@Comment("회원 비밀번호 이력")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPasswordHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_history_id")
    @Comment("비밀번호 이력 ID")
    private Long id;

    @Column(name = "memberId", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "password", nullable = false, length = 255)
    @Comment("비밀번호")
    private String password;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberPasswordHistory(Long memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}

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

@Getter
@Entity
@Table(name = "member_password_histories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberPasswordHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "password_history_id")
    private Long id;

    @Column(name = "memberId", nullable = false)
    private Long memberId;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberPasswordHistory(Long memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
}

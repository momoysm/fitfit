package com.ecommerce.member.entity;

import com.ecommerce.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "members")
@Comment("회원")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Comment("회원 ID")
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @Comment("이메일")
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    @Comment("비밀번호")
    private String password;

    @Column(name = "name", nullable = false, length = 50)
    @Comment("이름")
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    @Comment("전화번호")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    @Comment("회원 타입")
    private MemberType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    @Comment("회원 상태")
    private MemberStatus status;

    @Column(name = "email_verified", nullable = false, length = 20)
    @Comment("이메일 인증 여부")
    private boolean emailVerified = false;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Builder(access = AccessLevel.PRIVATE)
    private Member(
        String email
        , String password
        , String name
        , String phone
        , MemberType type
    ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.status = MemberStatus.ACTIVE; // 최초 생성 시 활성화 상태로 시작
    }

    public static Member of(
        String email
        , String password
        , String name
        , String phone
        , MemberType type
    ) {
        return Member.builder()
            .email(email)
            .password(password)
            .name(name)
            .phone(phone)
            .type(type)
            .build();
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateStatus(MemberStatus status) {
        this.status = status;
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void verifyEmail() {
        this.emailVerified = true;
    }

    public void updateLastLoginAt() {
        this.lastLoginAt = LocalDateTime.now();
    }

    public void activate() {
        this.status = MemberStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = MemberStatus.INACTIVE;
    }

    public void suspend() {
        this.status = MemberStatus.SUSPENDED;
    }
}

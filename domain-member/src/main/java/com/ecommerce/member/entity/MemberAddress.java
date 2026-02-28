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
@Table(name = "member_addresses")
@Comment("회원 주소")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    @Comment("주소 ID")
    private Long id;

    @Column(name = "member_id", nullable = false)
    @Comment("회원 ID")
    private Long memberId;

    @Column(name = "address_name", nullable = false, length = 50)
    @Comment("주소 별칭 (집, 회사 등)")
    private String addressName;

    @Column(name = "receiver_name", nullable = false, length = 50)
    @Comment("수령인 이름")
    private String receiverName;

    @Column(name = "receiver_phone", nullable = false, length = 20)
    @Comment("수령인 전화번호")
    private String receiverPhone;

    @Column(name = "zip_code", nullable = false, length = 10)
    @Comment("우편번호")
    private String zipCode;

    @Column(name = "address", nullable = false, length = 200)
    @Comment("주소")
    private String address;

    @Column(name = "address_detail", length = 100)
    @Comment("상세 주소")
    private String addressDetail;

    @Column(name = "is_default", nullable = false)
    @Comment("기본 배송지 여부")
    private Boolean isDefault;

    @Builder(access = AccessLevel.PRIVATE)
    private MemberAddress(
        Long memberId
        , String addressName
        , String receiverName
        , String receiverPhone
        , String zipCode
        , String address
        , String addressDetail
    ) {
        this.memberId = memberId;
        this.addressName = addressName;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.zipCode = zipCode;
        this.address = address;
        this.addressDetail = addressDetail;
        this.isDefault = false;
    }
}

package com.ecommerce.admin.member.dto;

import com.ecommerce.member.entity.MemberStatus;
import jakarta.validation.constraints.Pattern;

public record MemberUpdateRequest(
    String name,

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
    String phone,

    MemberStatus status
) {

}

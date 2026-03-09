package com.ecommerce.admin.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ValidateAdminKeyRequest(
    @NotBlank(message = "관리자 키는 필수 입력 항목입니다.")
    @Size(max = 255, message = "관리자 키는 최대 255자 이하로 입력해야 합니다.")
    String adminKey
) {

}

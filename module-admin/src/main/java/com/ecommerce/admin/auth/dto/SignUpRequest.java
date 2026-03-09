package com.ecommerce.admin.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Size(max = 50, message = "이메일은 50자 이하여야 합니다.")
    @Email(message = "이메일 형식이 맞지 않습니다.")
    String email,

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-Za-z0-9!@#$%^&*()-+=]{8,20}$",
        message = "비밀번호는 영문 대문자, 소문자, 숫자, 특수문자를 포함하여 8자 이상 20자 이하여야 합니다."
    )
    String password,

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    @Size(min = 2, max = 10, message = "이름은 2자이상 10자 이내로 입력해야 합니다.")
    @Pattern(
        regexp = "^[가-힣a-zA-Z]+$"
        , message = "이름은 한글 또는 영문만 가능합니다."
    )
    String name,

    @NotBlank(message = "휴대전화번호는 필수 입력 항목입니다.")
    @Pattern(
        regexp = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$",
        message = "휴대전화번호 형식에 맞지 않습니다."
    )
    String phone
) {

}

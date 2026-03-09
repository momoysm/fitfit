package com.ecommerce.admin.exception;

import com.ecommerce.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdminErrorCode implements ErrorCode {
    INVALID_ADMIN_KEY(400, "A001", "관리자 인증 키가 올바르지 않습니다."),
    ;

    private final int httpStatus;
    private final String code;
    private final String message;
}

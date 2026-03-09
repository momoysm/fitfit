package com.ecommerce.member.exception;

import com.ecommerce.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "M001", "회원이 존재하지 않습니다."),
    MEMBER_DUPLICATE(HttpStatus.CONFLICT.value(), "M002", "이미 존재하는 회원입니다."),
    ;

    private final int httpStatus;
    private final String code;
    private final String message;
}

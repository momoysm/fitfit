package com.ecommerce.common.dto;

import com.ecommerce.common.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse<T> {

    private final int status;

    private final String code;

    private final String message;

    @JsonInclude(Include.NON_EMPTY)
    private final Map<String, Object> data;

    private final LocalDateTime timestamp;

    // BusinessException 에러
    @Builder
    public static <T> ErrorResponse<T> of(
        BusinessException e
    ) {
        return ErrorResponse.<T>builder()
            .status(e.getErrorCode().getHttpStatus())
            .code(e.getErrorCode().getCode())
            .message(e.getErrorCode().getMessage())
            .data(e.getDetails())
            .timestamp(LocalDateTime.now())
            .build();
    }

    // 시스템 에러
    @Builder
    public static <T> ErrorResponse<T> of(String message) {
        return ErrorResponse.<T>builder()
            .status(500)
            .code("INTERNAL_SERVER_ERROR")
            .message(message)
            .timestamp(LocalDateTime.now())
            .build();
    }
}

package com.ecommerce.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponseDto<T> {

    private final int code;

    private final String message;

    @JsonInclude(Include.NON_NULL)
    private final T data;

    @Builder
    public static <T> ApiResponseDto<T> of(int code, String message, T data) {
        return ApiResponseDto.<T>builder()
            .code(code)
            .message(message)
            .data(data)
            .build();
    }

    @Builder
    public static <T> ApiResponseDto<T> of(String message, T data) {
        return ApiResponseDto.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(data)
            .build();
    }

    @Builder
    public static <T> ApiResponseDto<T> of(int code, String message) {
        return ApiResponseDto.<T>builder()
            .code(code)
            .message(message)
            .data(null)
            .build();
    }

    @Builder
    public static <T> ApiResponseDto<T> of(String message) {
        return ApiResponseDto.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(null)
            .build();
    }

}

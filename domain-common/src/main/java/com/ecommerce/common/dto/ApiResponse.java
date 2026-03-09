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
public class ApiResponse<T> {

    private final int code;

    private final String message;

    @JsonInclude(Include.NON_NULL)
    private final T data;

    public static <T> ApiResponse<T> of(int code, String message, T data) {
        return ApiResponse.<T>builder()
            .code(code)
            .message(message)
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> of(String message, T data) {
        return ApiResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> of(T data) {
        return ApiResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message("SUCCESS")
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> of(String message) {
        return ApiResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(null)
            .build();
    }

    public static <T> ApiResponse<T> of() {
        return ApiResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message("SUCCESS")
            .data(null)
            .build();
    }

}

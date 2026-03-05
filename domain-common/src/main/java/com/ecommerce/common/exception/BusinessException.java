package com.ecommerce.common.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    Map<String, Object> details = new HashMap<>();

    protected BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    protected void addDetail(String key, Object value) {
        this.details.put(key, value);
    }
}

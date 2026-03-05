package com.ecommerce.common.exception;

public interface ErrorCode {

    int getHttpStatus();

    String getCode();

    String getMessage();

}

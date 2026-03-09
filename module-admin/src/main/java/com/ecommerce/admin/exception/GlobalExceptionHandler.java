package com.ecommerce.admin.exception;

import com.ecommerce.common.dto.ErrorResponse;
import com.ecommerce.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse<?>> businessException(
        BusinessException e
    ) {
        e.getDetails().forEach((key, value) ->
            log.error("key={}, value = {}", key, value)
        );

        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
            .body(ErrorResponse.of(e));
    }

}

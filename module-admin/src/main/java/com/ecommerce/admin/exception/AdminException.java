package com.ecommerce.admin.exception;

import com.ecommerce.common.exception.BusinessException;
import com.ecommerce.common.exception.ErrorCode;

public abstract class AdminException extends BusinessException {

    public AdminException(ErrorCode errorCode) {
        super(errorCode);
    }
}

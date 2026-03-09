package com.ecommerce.admin.exception;

import com.ecommerce.common.exception.ErrorCode;

public class InvalidAdminKeyException extends AdminException {

    public InvalidAdminKeyException(ErrorCode errorCode, String adminKey) {
        super(errorCode);
        addDetail("adminKey", adminKey);
    }
}

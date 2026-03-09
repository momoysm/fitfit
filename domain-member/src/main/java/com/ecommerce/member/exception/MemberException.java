package com.ecommerce.member.exception;

import com.ecommerce.common.exception.BusinessException;
import com.ecommerce.common.exception.ErrorCode;

public abstract class MemberException extends BusinessException {

    public MemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}

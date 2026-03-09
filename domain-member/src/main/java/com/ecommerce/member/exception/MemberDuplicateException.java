package com.ecommerce.member.exception;

public class MemberDuplicateException extends MemberException {

    public MemberDuplicateException(String email) {
        super(MemberErrorCode.MEMBER_DUPLICATE);
        addDetail("email", email);
    }
}

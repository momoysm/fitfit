package com.ecommerce.member.exception;

public class MemberNotFoundException extends MemberException {

    public MemberNotFoundException(Long memberId) {
        super(MemberErrorCode.MEMBER_NOT_FOUND);
        addDetail("memberId", memberId);
    }

    public MemberNotFoundException(String email) {
        super(MemberErrorCode.MEMBER_NOT_FOUND);
        addDetail("email", email);
    }
}

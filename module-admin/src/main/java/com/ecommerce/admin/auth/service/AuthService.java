package com.ecommerce.admin.auth.service;

import com.ecommerce.admin.auth.dto.SignUpResponse;
import com.ecommerce.admin.exception.AdminErrorCode;
import com.ecommerce.admin.exception.InvalidAdminKeyException;
import com.ecommerce.common.constant.AuthConstant;
import com.ecommerce.member.entity.Member;
import com.ecommerce.member.entity.MemberType;
import com.ecommerce.member.exception.MemberDuplicateException;
import com.ecommerce.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j(topic = "AuthService")
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    private final MemberRepository memberRepository;


    public void validateAdminKey(String adminKey) {

        if (!adminKey.equals(AuthConstant.ADMIN_KEY)) {
            // log.error("관리자 키 불일치 | adminKey : {}", adminKey);
            throw new InvalidAdminKeyException(AdminErrorCode.INVALID_ADMIN_KEY, adminKey);
        }

    }

    public SignUpResponse signUp(
        String email
        , String password
        , String name
        , String phone
    ) {

        if (memberRepository.existsByEmail(email)) {
            throw new MemberDuplicateException(email);
        }

        Member newAdmin = Member.of(
            email
            , passwordEncoder.encode(password)
            , name
            , phone
            , MemberType.ADMIN
        );

        memberRepository.save(newAdmin);

        return SignUpResponse.of(
            newAdmin.getId()
            , newAdmin.getEmail()
            , newAdmin.getName()
            , newAdmin.getCreatedAt()
        );
    }
}

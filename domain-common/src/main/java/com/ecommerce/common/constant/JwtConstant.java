package com.ecommerce.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtConstant {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    public static final long ACCESS_TOKEN_TIME = 60 * 60 * 1000L; // 1시간
    public static final long REFRESH_TOKEN_TIME = 14 * 24 * 60 * 60 * 1000L; // 2주
}

package com.ecommerce.admin.auth.controller;

import com.ecommerce.admin.auth.dto.SignUpRequest;
import com.ecommerce.admin.auth.dto.SignUpResponse;
import com.ecommerce.admin.auth.dto.ValidateAdminKeyRequest;
import com.ecommerce.admin.auth.service.AuthService;
import com.ecommerce.common.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/validate-admin-key")
    public ResponseEntity<ApiResponse<Void>> valdiateAdminKey(
        @RequestBody @Valid ValidateAdminKeyRequest request
    ) {
        authService.validateAdminKey(request.adminKey());

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of());
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignUpResponse>> singUp(
        @RequestBody @Valid SignUpRequest request
    ) {

        SignUpResponse response = authService.signUp(
            request.email()
            , request.password()
            , request.name()
            , request.phone()
        );

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of(response));
    }

}

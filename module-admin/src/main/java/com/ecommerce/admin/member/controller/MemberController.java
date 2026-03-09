package com.ecommerce.admin.member.controller;

import com.ecommerce.admin.member.dto.MemberListSearchCondition;
import com.ecommerce.admin.member.dto.MemberResponse;
import com.ecommerce.admin.member.dto.MemberUpdateRequest;
import com.ecommerce.admin.member.service.MemberService;
import com.ecommerce.common.dto.ApiResponse;
import com.ecommerce.common.dto.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public ResponseEntity<ApiResponse<PageResponse<MemberResponse>>> getMembers(
        MemberListSearchCondition condition,
        @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        PageResponse<MemberResponse> response =
            memberService.getMembers(condition, pageable);

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of(response));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> getMember(
        @PathVariable Long memberId
    ) {
        MemberResponse response = memberService.getMember(memberId);

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of(response));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<ApiResponse<MemberResponse>> updateMember(
        @PathVariable Long memberId,
        @RequestBody @Valid MemberUpdateRequest request
    ) {
        MemberResponse response = memberService.updateMember(
            memberId,
            request.name(),
            request.phone(),
            request.status()
        );

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of(response));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<ApiResponse<Void>> deleteMember(
        @PathVariable Long memberId
    ) {
        memberService.deleteMember(memberId);

        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse.of());
    }
}

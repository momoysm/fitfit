package com.ecommerce.admin.member.dto;

import com.ecommerce.member.entity.MemberStatus;
import com.ecommerce.member.entity.MemberType;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public record MemberListSearchCondition(
    String searchType,

    String searchText,

    MemberType type,

    MemberStatus status,

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate startDate,

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endDate
) {

}

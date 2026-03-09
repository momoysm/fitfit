package com.ecommerce.common.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageResponse<T> {

    private final Integer currentPage;
    private final Integer totalPage;
    private final Long totalElements;
    private final Boolean hasNextPage;
    private final List<T> data;

    public static <T> PageResponse<T> of(final Page<?> page, final List<T> data) {
        return PageResponse.<T>builder()
            .currentPage(page.getNumber() + 1)
            .totalPage(page.getTotalPages())
            .totalElements(page.getTotalElements())
            .hasNextPage(page.hasNext())
            .data(data)
            .build();
    }
}

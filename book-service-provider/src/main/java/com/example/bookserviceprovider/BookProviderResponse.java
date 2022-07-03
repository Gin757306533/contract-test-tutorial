package com.example.bookserviceprovider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookProviderResponse {
    private String title;
    private List<Author> authors;
    private BigDecimal price;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Author {
        private String authorName;
        private String authorCompany;
    }
}
package com.example.bookserviceprovider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookProviderResponse {
    private String title;
    private List<Author> authors;
    private Integer price;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Author {
        private String name;
        private String company;
    }
}
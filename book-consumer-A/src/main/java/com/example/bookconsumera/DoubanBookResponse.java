package com.example.bookconsumera;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoubanBookResponse {
    private String title;
    private List<Author> authors;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Author {
        private String name;
        private String company;
    }
}

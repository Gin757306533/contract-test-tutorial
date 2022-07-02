package com.example.bookserviceprovider;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public BookProviderResponse getBookById(Long id) {
        return BookProviderResponse.builder()
                .title("《Java从入门到放弃》")
                .authors(
                        List.of(
                                BookProviderResponse.Author.builder()
                                        .name("张三")
                                        .company("Thoughtworks")
                                        .build(),
                                BookProviderResponse.Author.builder()
                                        .name("李四")
                                        .company("Google")
                                        .build()
                        )
                )
                .price(129)
                .build();
    }
}

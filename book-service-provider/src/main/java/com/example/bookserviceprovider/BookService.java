package com.example.bookserviceprovider;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {
    public BookProviderResponse getBookById(Long id) {
        return BookProviderResponse.builder()
                .title("《Java从入门到放弃》")
                .authors(
                        List.of(
                                BookProviderResponse.Author.builder()
                                        .authorName("张三")
                                        .authorCompany("Thoughtworks")
                                        .build(),
                                BookProviderResponse.Author.builder()
                                        .authorName("李四")
                                        .authorCompany("Google")
                                        .build()
                        )
                )
                .price(new BigDecimal("9898989898989898989898989898989898989898989898989898989.9999999999999999999999"))
                .build();
    }
}

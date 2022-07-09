package com.example.bookserviceprovider;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {
    public BookProviderResponse getBookById(Long id) {
        return BookProviderResponse.builder()
                .title("Effective Java")
                .authors(
                        List.of(
                                BookProviderResponse.Author.builder()
                                        .authorName("Joshua Bloch")
                                        .authorCompany("Sun Microsystems & Google")
                                        .build()
                        )
                )
                .price(new BigDecimal("9898989898989898989898989898989898989898989898989898989.9999999999999999999999"))
                .build();
    }
}

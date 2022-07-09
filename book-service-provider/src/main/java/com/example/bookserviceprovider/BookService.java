package com.example.bookserviceprovider;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public BookProviderResponse getBookById(Long id) {
        return BookProviderResponse.builder()
                .title("Effective Java")
                .authors(
                        List.of(
                                BookProviderResponse.Author.builder()
                                        .name("Joshua Bloch")
                                        .company("Sun Microsystems & Google")
                                        .build()
                        )
                )
                .price(49.49f)
                .build();
    }
}

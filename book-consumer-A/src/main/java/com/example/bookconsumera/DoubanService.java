package com.example.bookconsumera;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubanService {
    public static DoubanBookResponse getBookById(Long id) {
        return DoubanBookResponse.builder()
                .title("《Java从入门到放弃》")
                .authors(
                        List.of(
                                DoubanBookResponse.Author.builder()
                                        .name("张三")
                                        .company("Thoughtworks")
                                        .build(),
                                DoubanBookResponse.Author.builder()
                                        .name("李四")
                                        .company("Google")
                                        .build()
                        )
                )
                .build();
    }
}

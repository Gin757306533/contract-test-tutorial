package com.example.bookconsumera;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubanService {

    private final BookServiceClient client;

    public DoubanService(BookServiceClient bookServiceClient) {
        this.client = bookServiceClient;
    }

    public DoubanBookResponse getBookById(Long id) {
        return client.getBook(id);

    }
}

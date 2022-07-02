package com.example.bookconsumerb;

import org.springframework.stereotype.Service;

@Service
public class TaoBaoService {

    private final BookServiceClient client;

    public TaoBaoService(BookServiceClient bookServiceClient) {
        this.client = bookServiceClient;
    }

    public TaoBaoBookResponse getBookById(Long id) {
        return client.getBook(id);
    }
}

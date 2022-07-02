package com.example.bookconsumerb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "bookServiceClient", url = "${app.book-service.url}")
public interface BookServiceClient {

    @GetMapping("/books/{id}")
    TaoBaoBookResponse getBook(@PathVariable Long id);
}

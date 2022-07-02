package com.example.bookconsumera;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookServiceClient", url = "${app.book-service.url}")
public interface BookServiceClient {

    @GetMapping("/{id}")
    DoubanBookResponse getBook(@PathVariable Long id);
}

package com.example.bookconsumera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class DouBanController {
    @GetMapping("/{id}")
    public DoubanBookResponse getBook(@PathVariable Long id) {
        return DoubanService.getBookById(id);
    }
}

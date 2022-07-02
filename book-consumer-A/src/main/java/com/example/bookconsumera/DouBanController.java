package com.example.bookconsumera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class DouBanController {
    private final DoubanService doubanService;

    public DouBanController(DoubanService doubanService) {
        this.doubanService = doubanService;
    }

    @GetMapping("/{id}")
    public DoubanBookResponse getBook(@PathVariable Long id) {
        return doubanService.getBookById(id);
    }
}

package com.example.bookconsumerb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class TaoBaoController {
    private final TaoBaoService taoBaoService;

    public TaoBaoController(TaoBaoService taoBaoService) {
        this.taoBaoService = taoBaoService;
    }

    @GetMapping("/{id}")
    public TaoBaoBookResponse getBook(@PathVariable Long id) {
        return taoBaoService.getBookById(id);
    }
}

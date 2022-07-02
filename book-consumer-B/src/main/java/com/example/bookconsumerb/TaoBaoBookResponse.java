package com.example.bookconsumerb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaoBaoBookResponse {
    private String title;
    private Integer price;
}

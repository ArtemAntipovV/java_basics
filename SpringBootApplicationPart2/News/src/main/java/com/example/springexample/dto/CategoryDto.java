package com.example.springexample.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Long id;

    private String title;

   private List<NewsDto> news = new ArrayList<>();

}
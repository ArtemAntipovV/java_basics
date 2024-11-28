package com.example.springexample.dto;

import com.example.springexample.enity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class NewsDto {

    private Long id;
    private String title;
    private String text;
    private LocalDateTime date;

    private String category;



    }


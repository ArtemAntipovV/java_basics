package com.example.springexample.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class NewsDto {

    private Long id;
    private String title;
    private String text;
    private LocalDateTime date;

}

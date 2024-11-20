package com.example.newsfeed.dto;


import lombok.Data;


import java.util.Date;

@Data
public class NewsDto {

    private long id;
    private String title;
    private String text;
    private Date date;

}

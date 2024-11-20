package com.example.newsfeed.controllers;


import com.example.newsfeed.dto.NewsDto;
import com.example.newsfeed.services.NewsCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/api/news")
public class APIController {

    private final NewsCRUDService newsService;

    public APIController(NewsCRUDService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> getNewsById(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        NewsDto newsDto = newsService.getById(id);
        if (newsDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newsDto, HttpStatus.OK);
    }

    @GetMapping
    public Collection<NewsDto> getAllNews() {
        return newsService.getAll();
    }

    @PostMapping()
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto) {
        if (newsDto.getTitle() == null || newsDto.getText() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        newsDto.setDate(currentDate);

        NewsDto createdNews = newsService.create(newsDto);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        if (newsDto.getTitle() == null || newsDto.getText() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LocalDateTime now = LocalDateTime.now();
        Date currentDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        newsDto.setDate(currentDate);

        NewsDto updatedNews = newsService.update(id, newsDto);
        if (updatedNews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NewsDto> deleteNews(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        NewsDto newsDto = newsService.delete(id);
        if (newsDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsDto, HttpStatus.OK);
    }
}

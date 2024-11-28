package com.example.springexample.controllers;


import com.example.springexample.dto.NewsDto;
import com.example.springexample.service.NewsCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsCRUDService newsService;

    public NewsController(NewsCRUDService newsService) {
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
    public void createNews(@RequestBody NewsDto newsDto) {
        newsService.create(newsDto);
    }

    @PutMapping("/{id}")
    public void updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        newsService.update(newsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.delete(id);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Collection<NewsDto>> getNewsByCategoryId(@PathVariable Long id) {
        Collection<NewsDto> newsDtos = newsService.getNewsByCategoryId(id);
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }
}

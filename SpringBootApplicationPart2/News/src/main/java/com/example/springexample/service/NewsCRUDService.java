package com.example.springexample.service;

import com.example.springexample.dto.NewsDto;
import com.example.springexample.enity.News;
import com.example.springexample.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;


@RequiredArgsConstructor
@Slf4j
@Service
public class NewsCRUDService implements CRUDService<NewsDto> {

    private final NewsRepository newsRepository;
    private final ConcurrentHashMap<Long, NewsDto> news = new ConcurrentHashMap<>();


    @Override
    public NewsDto getById(Long id) {
        log.info("Get by ID: " + id);
        News news = newsRepository.findById(id).orElseThrow();
        return mapToDto(news);
    }

    @Override
    public Collection<NewsDto> getAll() {
        log.info("Get all");
        return newsRepository.findAll().stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto item) {
        log.info("Create");
        News news = mapToEntity(item);
        newsRepository.save(news);
    }



    @Override
    public void update(NewsDto item) {
        log.info("Update");
        News news = mapToEntity(item);
        newsRepository.save(news);
    }

    @Override
    public void delete(Long id) {
        newsRepository.deleteById(id);
    }

    public static NewsDto mapToDto (News news) {
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setDate(news.getDate());

        return newsDto;

    }

    public static News mapToEntity (NewsDto newsDto) {
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        news.setDate(newsDto.getDate());

        return news;
    }


}

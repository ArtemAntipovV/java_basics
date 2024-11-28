package com.example.springexample.service;


import com.example.springexample.dto.NewsDto;
import com.example.springexample.enity.Category;
import com.example.springexample.enity.News;
import com.example.springexample.repositories.CategoryRepository;
import com.example.springexample.repositories.NewsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class NewsCRUDService implements CRUDService<NewsDto> {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;


    public Collection<NewsDto> getNewsByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        List<News> newsList = newsRepository.findByCategory(category);
        return newsList.stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

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
    public void create(NewsDto newsDto) {
        log.info("Create");

        News news = mapToEntity(newsDto);
        String categoryName = newsDto.getCategory(); // Получение названия категории

        List<Category> categories = categoryRepository.findByTitle(categoryName);

        Category category;

        if (categories.size() == 1) {
            category = categories.get(0);
        } else if (categories.isEmpty()) {
            // Создаем новую категорию
            category = new Category();
            category.setTitle(categoryName);
            category = categoryRepository.save(category);
        } else {
            throw new RuntimeException("Найдено несколько категорий с названием '" + categoryName + "'.");
        }
        news.setCategory(category);
        newsRepository.save(news);
    }

    @Override
    public void update(NewsDto newsDto) {

        News existingNews = newsRepository.findById(newsDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("News not found"));

        String categoryName = newsDto.getCategory();
        List<Category> categories = categoryRepository.findByTitle(categoryName);

        Category category;

        if (categories.size() == 1) {
            category = categories.get(0);
        } else if (categories.isEmpty()) {
            category = new Category();
            category.setTitle(categoryName);
            category = categoryRepository.save(category);
        } else {
            throw new RuntimeException("Найдено несколько категорий с названием '" + categoryName + "'.");
        }

        existingNews.setTitle(newsDto.getTitle());
        existingNews.setText(newsDto.getText());
        existingNews.setCategory(category);

        newsRepository.save(existingNews);
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
        if (news.getCategory() != null) {
            newsDto.setCategory(news.getCategory().getTitle());
        }
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

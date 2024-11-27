package com.example.springexample.service;


import com.example.springexample.dto.CategoryDto;
import com.example.springexample.enity.Category;
import com.example.springexample.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryCRUDService implements CRUDService<CategoryDto> {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryDto getById(Long id) {
        log.info("Get by id" + id);
        return mapToDto(categoryRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection<CategoryDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(CategoryDto categoryDto) {
      categoryRepository.save(mapToEntity(categoryDto));
    }

    @Override
    public void update(CategoryDto categoryDto) {
        categoryRepository.save(mapToEntity(categoryDto));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public static  Category mapToEntity(CategoryDto categoryDto) {
            Category category = new Category();
            category.setId(categoryDto.getId());
            category.setTitle(categoryDto.getTitle());
            category.setNews(categoryDto.getNews()
                    .stream()
                    .map(NewsCRUDService::mapToEntity)
                    .toList()
            );
            return category;
    }

    public static CategoryDto mapToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setNews(category.getNews()
                .stream()
                .map(NewsCRUDService::mapToDto)
                .toList()
        );
        return categoryDto;
    }
}
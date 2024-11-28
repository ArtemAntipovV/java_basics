package com.example.springexample.controllers;


import com.example.springexample.dto.CategoryDto;
import com.example.springexample.repositories.CategoryRepository;
import com.example.springexample.service.CategoryCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@Slf4j
@RequestMapping("/api/category")
@RestController
@RequiredArgsConstructor
public class CategoryController{


    private final CategoryCRUDService category;


    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
       return category.getById(id);
    }

    @GetMapping
    public Collection<CategoryDto> getAll() {
        return category.getAll();
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        category.create(categoryDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        category.getById(id);
        category.update(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        category.delete(id);
    }


}
package com.example.springexample.service;

import com.example.springexample.dto.CategoryDto;
import com.example.springexample.dto.NewsDto;
import com.example.springexample.enity.Category;
import com.example.springexample.enity.News;

import java.util.Collection;

public interface CRUDService<T> {
    T getById (Long id);
    Collection<T> getAll();
    void create(T item);
    void update (T item);
    void delete(Long id);
}

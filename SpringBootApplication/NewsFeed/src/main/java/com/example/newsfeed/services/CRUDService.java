package com.example.newsfeed.services;


import com.example.newsfeed.dto.NewsDto;

import java.util.Collection;

public interface CRUDService<T> {
    T getById (Long id);
    Collection<T> getAll();
    NewsDto create(T item);
    NewsDto update (Long id, T item);
    NewsDto delete(Long id);
}

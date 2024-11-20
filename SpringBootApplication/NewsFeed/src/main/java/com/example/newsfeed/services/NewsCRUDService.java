package com.example.newsfeed.services;

import com.example.newsfeed.dto.NewsDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsCRUDService implements CRUDService<NewsDto> {

    private final ConcurrentHashMap<Long, NewsDto> news = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong(0);

    @Override
    public NewsDto getById(Long id) {
        System.out.println("Get by ID: " + id);
        return news.get(id);
    }

    @Override
    public Collection<NewsDto> getAll() {
        System.out.println("Get all");
        return news.values();
    }

    @Override
    public NewsDto create(NewsDto item) {
        System.out.println("Create");
        long nextId = idCounter.incrementAndGet();
        item.setId(nextId);
        news.put(nextId, item);
        return item;
    }

    @Override
    public NewsDto update(Long id, NewsDto item) {
        System.out.println("Update " + id);
        item.setId(id);
        news.put(id, item);
        return item;
    }

    @Override
    public NewsDto delete(Long id) {
        System.out.println("Delete " + id);
        return news.remove(id);
    }
}

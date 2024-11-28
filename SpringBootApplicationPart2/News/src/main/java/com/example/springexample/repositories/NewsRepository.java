package com.example.springexample.repositories;


import com.example.springexample.enity.Category;
import com.example.springexample.enity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByCategory(Category category);
}
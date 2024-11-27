package com.example.springexample.enity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name= "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "title")
    private String title;

    @Column(name= "text")
    private String text;

    @CreationTimestamp
    @Column(name= "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name= "category_id", nullable = false)
    private Category category;


}
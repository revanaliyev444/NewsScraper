package com.example.interntask.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "info")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String url;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String image;

    @Column(nullable = false, columnDefinition = "Text")
    String text;

    @Column(nullable = false)
    String author;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "news_article_tags",
            joinColumns = @JoinColumn(name = "news_article_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tags> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @CreationTimestamp
    LocalDateTime createdAt;
}

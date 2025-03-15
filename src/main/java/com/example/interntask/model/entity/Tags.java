package com.example.interntask.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @ManyToMany(mappedBy = "tags")
    List<NewsInfo> newsInfos;
}

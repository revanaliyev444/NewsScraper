package com.example.interntask.repository;

import com.example.interntask.model.entity.NewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsInfo, Long> {
}

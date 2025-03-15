package com.example.interntask.services;

import com.example.interntask.model.entity.NewsInfo;
import com.example.interntask.repository.NewsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<NewsInfo> getAllNews() {
        return newsRepository.findAll();
    }
}

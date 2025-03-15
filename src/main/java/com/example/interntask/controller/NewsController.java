package com.example.interntask.controller;

import com.example.interntask.model.entity.NewsInfo;
import com.example.interntask.services.NewsService;
import com.example.interntask.services.ScrapingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("v1/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private ScrapingService webScraperService;

    @GetMapping("/scrape")
    public void scrapeNewsFromWebsite() throws IOException {
        webScraperService.scrapeNews();
    }

    @GetMapping
    public List<NewsInfo> getAllNews() {
        return newsService.getAllNews();
    }
}
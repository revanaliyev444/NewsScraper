package com.example.interntask.services;

import com.example.interntask.model.entity.Category;
import com.example.interntask.model.entity.NewsInfo;
import com.example.interntask.model.entity.Tags;
import com.example.interntask.repository.CategoryRepository;
import com.example.interntask.repository.NewsRepository;
import com.example.interntask.repository.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.apache.bcel.generic.Tag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScrapingService {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    CategoryRepository CategoryRepository;

    @Autowired
    TagRepository TagRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public void scrapeNews() throws IOException {
        String url = "https://apa.az/";
        Document document = Jsoup.connect(url).get();

        Elements newsElements = document.select(".news-item");

        for (Element element : newsElements) {
            String title = element.select(".news-title").text();
            String link = element.select("a").attr("href");
            String image = element.select(".news-image").attr("src");
            String content = element.select(".news-content").text();
            String categoryName = element.select(".news-category").text();
            String[] tagNames = element.select(".news-tags").text().split(",");

            Category category = categoryRepository.findByName(categoryName);
            if (category == null) {
                category = new Category();
                category.setName(categoryName);
                category = categoryRepository.save(category);
            }

            Set<Tags> tags = new HashSet<>();

            NewsInfo news = new NewsInfo();
            news.setTitle(title);
            news.setUrl(link);
            news.setImage(image);
            news.setTitle(content);
            news.setCategory(category);
            news.setTags(tags);

            newsRepository.save(news);
        }
    }
}
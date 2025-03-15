package com.example.interntask.controller;

import com.example.interntask.repository.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("v1/tags")
public class TagController {
    @Autowired
    TagRepository tagRepository;

    @GetMapping
    List<Tag> getTagList() {
        return getTagList();
    }
}

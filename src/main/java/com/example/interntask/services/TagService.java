package com.example.interntask.services;

import com.example.interntask.model.entity.Tags;
import com.example.interntask.repository.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tags> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag setName(String name){
        Tag tag = tagRepository.findByName(name);
        return tag;
    }

    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}

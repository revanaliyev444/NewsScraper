package com.example.interntask.services;


import com.example.interntask.model.entity.Category;
import com.example.interntask.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List <Category> getAllCategories(){
                return categoryRepository.findAll();
    }

}

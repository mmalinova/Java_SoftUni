package com.example.springdataintro.service;

import com.example.springdataintro.model.entity.Category;
import com.example.springdataintro.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_FILE_PATH = "src/main/resources/categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH))
                .stream().filter(f -> !f.isEmpty())
                .forEach(catName -> {
                    Category category = new Category(catName);

                    categoryRepository.save(category);
                });
    }
}

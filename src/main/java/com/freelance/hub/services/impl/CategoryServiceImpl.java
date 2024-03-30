package com.freelance.hub.services.impl;

import com.freelance.hub.model.entity.Category;
import com.freelance.hub.constant.ECategory;
import com.freelance.hub.repository.CategoryRepository;
import com.freelance.hub.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getOrSave(ECategory category) {
        Optional<Category> optionalCategory = categoryRepository.findByName(category);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }

        Category currentCategory = Category.builder()
                .category(category)
                .build();

        return categoryRepository.saveAndFlush(currentCategory);
    }
}

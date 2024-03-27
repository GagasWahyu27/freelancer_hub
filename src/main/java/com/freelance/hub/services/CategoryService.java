package com.freelance.hub.services;

import com.freelance.hub.constant.ECategory;
import com.freelance.hub.model.entity.Category;

public interface CategoryService {
    Category getOrSave(ECategory category);
}

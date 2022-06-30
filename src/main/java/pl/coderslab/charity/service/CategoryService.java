package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.CategoryEntity;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryEntity> loadCategories();
}

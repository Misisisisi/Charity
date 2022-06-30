package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.CategoryEntity;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> loadCategories() {
        return categoryRepository.findAll();
    }
}

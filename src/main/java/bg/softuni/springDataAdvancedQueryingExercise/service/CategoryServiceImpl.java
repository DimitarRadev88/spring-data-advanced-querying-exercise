package bg.softuni.springDataAdvancedQueryingExercise.service;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Category;
import bg.softuni.springDataAdvancedQueryingExercise.repository.CategoryRepository;
import bg.softuni.springDataAdvancedQueryingExercise.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void addAll(List<Category> categories) {
        categoryRepository.saveAll(categories);
    }

    @Override
    public Set<Category> getRandomCategories() {
        long categoriesCount = ThreadLocalRandom.current().nextLong(categoryRepository.count());


        Set<Long> categoriesIds = new HashSet<>();
        for (int i = 0; i < categoriesCount; i++) {
            long id = ThreadLocalRandom.current().nextLong(categoryRepository.count()) + 1;
            categoriesIds.add(id);
        }

        Set<Category> categories = new HashSet<>();
        categoriesIds.forEach(id -> categories.add(categoryRepository.findById(id).get()));

        return categories;
    }

    @Override
    public Category getCategory(long l) {
        return categoryRepository.findById(l).get();
    }
}

package bg.softuni.springDataAdvancedQueryingExercise.service.interfaces;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {


    void addAll(List<Category> categories);

    Set<Category> getRandomCategories();

    Category getCategory(long l);
}

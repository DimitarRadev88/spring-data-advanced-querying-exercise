package bg.softuni.springDataAdvancedQueryingExercise.repository;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}

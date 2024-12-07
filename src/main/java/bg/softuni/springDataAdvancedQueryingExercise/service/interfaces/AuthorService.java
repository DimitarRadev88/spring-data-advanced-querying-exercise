package bg.softuni.springDataIntroExercise.service.interfaces;

import bg.softuni.springDataIntroExercise.entity.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface AuthorService {


    void addAll(List<Author> authors);

    Author getRandomAuthor();

    List<Author> getAllAuthorsWithBooksReleasedBefore(int year);

    List<Author> getAllAuthorsOrderedByCountOfBooksDescending();

    List<Author> getAllAuthorsWithFirstNameEndingWith(String nameEnd);

    Map<Author, Long> getAllAuthorsSortedByNumberOfBooksCopies();

}

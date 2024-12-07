package bg.softuni.springDataAdvancedQueryingExercise.service.interfaces;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Author;

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

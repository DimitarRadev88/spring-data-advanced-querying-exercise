package bg.softuni.springDataAdvancedQueryingExercise.service.interfaces;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Book;
import bg.softuni.springDataAdvancedQueryingExercise.enums.AgeRestriction;
import bg.softuni.springDataAdvancedQueryingExercise.enums.EditionType;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    void add(Book book);

    void addAll(List<Book> books);

    List<Book> getAllBooksReleasedAfterYear(int year);

    List<Book> getAllBooksFromAuthorOrderedByReleaseDateDescendingAndBookTitileAscending(String firstName, String lastName);

    List<Book> getAllBooksWithAgeRestriction(AgeRestriction ageRestriction);

    List<Book> getAllBooksWithEditionAndWithNumberOfCopiesLessThan(EditionType editionType, int maxNumberOfCopies);

    List<Book> getAllBooksWithPriceLessThanAndPriceHigherThan(BigDecimal lowerThanThreshold, BigDecimal higherThanThreshold);

    List<Book> getAllBooksWithReleaseYearNotEqualTo(String year);

    List<Book> getAllBooksReleasedBeforeDate(String date);

    List<Book> getAllBooksWithTitlesContainingSubstring(String substring);

    List<Book> getAllBooksFromAuthorsWithLastNameStartingWith(String authorLastNameStart);

    long getCountOfBooksWithTitleLengthGreaterThan(int minLength);

    Book getBookWithTitleEditionTypeAgeRestrictionAndPriceByTitle(String title);

}

package bg.softuni.springDataAdvancedQueryingExercise.repository;

import bg.softuni.springDataAdvancedQueryingExercise.entity.Book;
import bg.softuni.springDataAdvancedQueryingExercise.enums.AgeRestriction;
import bg.softuni.springDataAdvancedQueryingExercise.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    @Query("FROM Book b WHERE YEAR(b.releaseDate) > ?1")
    List<Book> findAllByReleaseDateYearGreaterThan(int year);

    List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int maxNumberOfCopies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lessThanThreshold, BigDecimal greaterThanThreshold);

    List<Book> findAllByReleaseDateIsLessThanOrReleaseDateIsGreaterThan(LocalDate from, LocalDate to);

    List<Book> findAllByReleaseDateLessThan(LocalDate toDate);

    List<Book> findAllByTitleContainingIgnoreCase(String substring);

    List<Book> findAllByAuthor_LastNameStartsWith(String substring);

    @Query("""
            SELECT COUNT(b.id) FROM Book b
            WHERE LENGTH(b.title) > ?1
            """)
    long countByTitleLengthGreaterThan(int length);

    @Query("""
            SELECT new Book(b.title, b.price, b.editionType, b.ageRestriction) FROM Book b
            WHERE b.title = ?1
            """)
    Book findBookTitleEditionTypeAgeRestrictionAndPriceByTitle(String title);

}

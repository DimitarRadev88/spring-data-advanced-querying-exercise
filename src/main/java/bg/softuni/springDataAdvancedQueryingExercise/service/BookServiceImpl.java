package bg.softuni.springDataIntroExercise.service;

import bg.softuni.springDataIntroExercise.entity.Author;
import bg.softuni.springDataIntroExercise.entity.Book;
import bg.softuni.springDataIntroExercise.enums.AgeRestriction;
import bg.softuni.springDataIntroExercise.enums.EditionType;
import bg.softuni.springDataIntroExercise.repository.BookRepository;
import bg.softuni.springDataIntroExercise.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void addAll(List<Book> books) {
        bookRepository.saveAll(books);
    }

    @Override
    public List<Book> getAllBooksReleasedAfterYear(int year) {
        return bookRepository.findAllByReleaseDateYearGreaterThan(year);
    }

    @Override
    public List<Book> getAllBooksFromAuthorOrderedByReleaseDateDescendingAndBookTitileAscending(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);

    }

    @Override
    public List<Book> getAllBooksWithAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> getAllBooksWithEditionAndWithNumberOfCopiesLessThan(EditionType editionType, int maxNumberOfCopies) {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, maxNumberOfCopies);
    }

    @Override
    public List<Book> getAllBooksWithPriceLessThanAndPriceHigherThan(BigDecimal lowerThanThreshold, BigDecimal higherThanThreshold) {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowerThanThreshold, higherThanThreshold);
    }

    @Override
    public List<Book> getAllBooksWithReleaseYearNotEqualTo(String year) {
        LocalDate to = LocalDate.parse("01-01-" + year , DATE_TIME_PATTERN);
        LocalDate from = LocalDate.parse("31-12-" + year, DATE_TIME_PATTERN);

        return bookRepository.findAllByReleaseDateIsLessThanOrReleaseDateIsGreaterThan(to, from);
    }

    @Override
    public List<Book> getAllBooksReleasedBeforeDate(String date) {
        return bookRepository.findAllByReleaseDateLessThan(LocalDate.parse(date, DATE_TIME_PATTERN));
    }

    @Override
    public List<Book> getAllBooksWithTitlesContainingSubstring(String substring) {
        return bookRepository.findAllByTitleContainingIgnoreCase(substring);
    }

    @Override
    public List<Book> getAllBooksFromAuthorsWithLastNameStartingWith(String authorLastNameStart) {
        return bookRepository.findAllByAuthor_LastNameStartsWith(authorLastNameStart);
    }

    @Override
    public long getCountOfBooksWithTitleLengthGreaterThan(int minLength) {
        return bookRepository.countByTitleLengthGreaterThan(minLength);
    }

    @Override
    public Book getBookWithTitleEditionTypeAgeRestrictionAndPriceByTitle(String title) {
        return bookRepository.findBookTitleEditionTypeAgeRestrictionAndPriceByTitle(title);
    }


}

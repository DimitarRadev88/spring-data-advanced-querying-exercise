package bg.softuni.springDataIntroExercise.service;

import bg.softuni.springDataIntroExercise.entity.Author;
import bg.softuni.springDataIntroExercise.repository.AuthorRepository;
import bg.softuni.springDataIntroExercise.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAll(List<Author> authors) {
        authorRepository.saveAll(authors);
    }

    @Override
    public Author getRandomAuthor() {
        long id = ThreadLocalRandom.current().nextLong(authorRepository.count()) + 1;
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> getAllAuthorsWithBooksReleasedBefore(int year) {
        return authorRepository.findAllByHavingBooksReleasedBeforeYear(year);
    }

    @Override
    public List<Author> getAllAuthorsOrderedByCountOfBooksDescending() {
        return authorRepository.findAllOrderByBooksCountDescending();
    }

    @Override
    public List<Author> getAllAuthorsWithFirstNameEndingWith(String nameEnd) {
        return authorRepository.findAllByFirstNameEndingWith(nameEnd);
    }

    @Override
    public Map<Author, Long> getAllAuthorsSortedByNumberOfBooksCopies() {
        List<Object[]> authorsWithSumOfBookCopies = authorRepository.findAllAuthorsWithSumOfBookCopiesOrderByBooksCopiesDesc();

        Map<Author, Long> result = new LinkedHashMap<>();

        authorsWithSumOfBookCopies.forEach(r -> result.put(((Author) r[0]), (long) r[1]));

        return result;
    }

}


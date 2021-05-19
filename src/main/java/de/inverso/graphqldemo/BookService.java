package de.inverso.graphqldemo;

import de.inverso.graphqldemo.model.Author;
import de.inverso.graphqldemo.model.Book;
import de.inverso.graphqldemo.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book createBook(String title, Integer pageCount, Optional<Author> authorOptional) {
        if (authorOptional.isPresent()) {
            Book book = Book.builder()
                    .title(title)
                    .pageCount(pageCount)
                    .author(authorOptional.get())
                    .build();
            return bookRepository.save(book);
        }
        return null;
    }

}

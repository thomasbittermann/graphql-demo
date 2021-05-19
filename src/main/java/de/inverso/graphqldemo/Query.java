package de.inverso.graphqldemo;

import de.inverso.graphqldemo.model.Book;
import de.inverso.graphqldemo.repo.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public Query(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> bookById(Long id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

}

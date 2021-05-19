package de.inverso.graphqldemo;

import de.inverso.graphqldemo.model.Author;
import de.inverso.graphqldemo.model.Book;
import de.inverso.graphqldemo.repo.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository repo;

    public BookResolver(AuthorRepository repo) {
        this.repo = repo;
    }

    public Author getAuthor(Book book) {
        return repo.findById(book.getAuthor().getId()).orElse(null);
    }

}

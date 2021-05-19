package de.inverso.graphqldemo;

import de.inverso.graphqldemo.model.Book;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final AuthorService authorService;
    private final BookService bookService;

    public Mutation(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public Book createBook(String title, Integer pageCount, Long authorId) {
        return bookService.createBook(title, pageCount, authorService.findById(authorId));
    }

    public Book createBook(String title, Integer pageCount, String authorFirstName, String authorLastName) {
        return bookService.createBook(title, pageCount, authorService.lookupOrCreateAuthor(authorFirstName, authorLastName));
    }

}

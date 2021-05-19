package de.inverso.graphqldemo;

import de.inverso.graphqldemo.model.Author;
import de.inverso.graphqldemo.repo.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Optional<Author> lookupOrCreateAuthor(String firstName, String lastName) {
        Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(firstName, lastName);

        if (authorOptional.isEmpty()) {
            try {
                Author author = authorRepository.save(Author.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .build());
                authorOptional = Optional.of(author);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return authorOptional;
    }

    public Optional<Author> findById(Long authorId) {
        return authorRepository.findById(authorId);
    }
}

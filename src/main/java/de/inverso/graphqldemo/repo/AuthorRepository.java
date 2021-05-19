package de.inverso.graphqldemo.repo;

import de.inverso.graphqldemo.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);

}

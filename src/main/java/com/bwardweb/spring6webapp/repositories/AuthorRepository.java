package com.bwardweb.spring6webapp.repositories;

import com.bwardweb.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

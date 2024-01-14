package com.bwardweb.spring6webapp.services;

import com.bwardweb.spring6webapp.domain.Author;
import com.bwardweb.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAuthors() {
        return authorRepository.findAll();
    }
}

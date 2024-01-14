package com.bwardweb.spring6webapp.services;

import com.bwardweb.spring6webapp.domain.Author;

public interface AuthorService {
    public Iterable<Author> findAuthors();
}

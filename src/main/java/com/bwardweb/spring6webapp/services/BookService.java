package com.bwardweb.spring6webapp.services;

import com.bwardweb.spring6webapp.domain.Book;

public interface BookService {
    public  Iterable<Book> findall();
}

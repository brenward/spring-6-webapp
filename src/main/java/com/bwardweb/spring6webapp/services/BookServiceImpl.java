package com.bwardweb.spring6webapp.services;

import com.bwardweb.spring6webapp.domain.Book;
import com.bwardweb.spring6webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findall() {
        return bookRepository.findAll();
    }
}

package com.bwardweb.spring6webapp.bootstrap;

import com.bwardweb.spring6webapp.domain.Author;
import com.bwardweb.spring6webapp.domain.Book;
import com.bwardweb.spring6webapp.domain.Publisher;
import com.bwardweb.spring6webapp.repositories.AuthorRepository;
import com.bwardweb.spring6webapp.repositories.BookRepository;
import com.bwardweb.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain driven design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);


        Author rob = new Author();
        rob.setFirstName("Rob");
        rob.setLastName("Burns");

        Book noEjb = new Book();
        noEjb.setTitle("No ejbs");
        noEjb.setIsbn("589654");

        Author robSaved = authorRepository.save(rob);
        Book noEjbSaved = bookRepository.save(noEjb);

        ericSaved.getBooks().add(dddSaved);
        dddSaved.getAuthors().add(ericSaved);
        robSaved.getBooks().add(noEjbSaved);
        noEjbSaved.getAuthors().add(robSaved);

        Publisher penguin = new Publisher();
        penguin.setPublisherName("Penguin");
        penguin.setAddress("Main Street");
        penguin.setCity("Dublin");
        penguin.setState("Irelend");
        penguin.setZip("D01 AF11");
        Publisher penguinSaved = publisherRepository.save(penguin);

        dddSaved.setPublisher(penguinSaved);
        noEjbSaved.setPublisher(penguinSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEjbSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(robSaved);



        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}

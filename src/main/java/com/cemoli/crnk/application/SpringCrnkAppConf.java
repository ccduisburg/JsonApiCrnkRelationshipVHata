package com.cemoli.crnk.application;

import com.cemoli.crnk.domain.model.Address;
import com.cemoli.crnk.domain.model.Library;
import com.cemoli.crnk.domain.repository.AddressRepository;
import com.cemoli.crnk.domain.repository.BookCategoryRepository;
import com.cemoli.crnk.domain.repository.BookRepository;

import com.cemoli.crnk.domain.model.Book;
import com.cemoli.crnk.domain.model.BookCategory;
import com.cemoli.crnk.domain.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
@ComponentScan(basePackages = {"com.cemoli.crnk.domain"})
public class SpringCrnkAppConf {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCrnkAppConf.class);
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostConstruct
    public void init() {
        LOGGER.info("################## inside init #######################");
        Book b1,b2,b3;
        b1=new Book("book1","bok1 hakkinda");
        b2=new Book("book2","bok2 hakkinda");
        b3= new Book("book3","bok3 hakkinda");

        BookCategory bc1,bc2;
        bc1=new BookCategory("Birinci");
        bc2=new BookCategory("Ikinci");

        Address a1 = new Address();
        a1.setLocation("Bochum");
        Library l1 = new Library();
        l1.setName("Zentralbibliothek RUB");
        l1.setAddress(a1);
        a1.setLibrary(l1);

        b1.setBookCategory(bc1);
        b2.setBookCategory(bc1);
        b3.setBookCategory(bc2);
        b1.setLibrary(l1);
        b2.setLibrary(l1);
        b3.setLibrary(l1);
        l1.setBooks(Stream.of(b1,b2,b3).collect(Collectors.toList()));

        bc1.setBooks(Stream.of(b1,b2).collect(Collectors.toSet()));
        bc2.setBooks(Stream.of(b3).collect(Collectors.toSet()));

        bookCategoryRepository.create(bc1);
        bookCategoryRepository.create(bc2);
        addressRepository.create(a1);
        libraryRepository.create(l1);
        bookRepository.create(b1);
        bookRepository.create(b2);
        bookRepository.create(b3);


    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory =
                new TomcatEmbeddedServletContainerFactory();
        return factory;
    }
}
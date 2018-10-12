package com.cemoli.crnk.application;

import com.cemoli.crnk.repository.BookCategoryRepository;
import com.cemoli.crnk.repository.BookRepository;

import com.cemoli.crnk.model.Book;
import com.cemoli.crnk.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
//@ComponentScan(basePackages = {"com.cemoli.crnk.repository"})
public class SpringCrnkAppConf {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;



    @PostConstruct
    public void init() {
       Book b1,b2,b3;
        b1=new Book(1000L,"book1","bok1 hakkinda");
        b2=new Book(1001L,"book2","bok2 hakkinda");
        b3= new Book(1003L,"book3","bok3 hakkinda");

        BookCategory bc1,bc2,bc3;
        bc1=new BookCategory(1000L,"Birinci");
        bc2=new BookCategory(1001L,"Ikinci");
        b1.setBookCategory(bc1);
        b2.setBookCategory(bc1);
        b3.setBookCategory(bc2);
    }
}
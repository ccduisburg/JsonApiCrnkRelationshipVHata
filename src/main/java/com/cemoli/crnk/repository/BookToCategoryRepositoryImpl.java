package com.cemoli.crnk.repository;

import com.cemoli.crnk.model.Book;
import com.cemoli.crnk.model.BookCategory;


import io.crnk.core.repository.RelationshipRepositoryBase;

import org.springframework.stereotype.Component;

@Component
public class BookToCategoryRepositoryImpl extends RelationshipRepositoryBase<Book, Long, BookCategory, Long> {
    protected BookToCategoryRepositoryImpl(Class<Book> sourceResourceClass, Class<BookCategory> targetResourceClass) {
        super(sourceResourceClass, targetResourceClass);
    }

}

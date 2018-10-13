package com.cemoli.crnk.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="book_category")
@Getter
@Setter
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
//    @OneToMany(mappedBy="bookCategory", cascade=CascadeType.ALL)
    @OneToMany(mappedBy="bookCategory")
    private Set<Book> books;

    public BookCategory(){}
    public BookCategory(String name){
        this.name=name;
    }


    public BookCategory(Long id, String name, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public BookCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        String result=String.format("Category[id=%d,name='%s']%n", id,name);
        if(books!=null){

            for(Book book:books){
                result+=String.format("Book[id=%d, title='%s']%n", book.getId(),book.getTitle());
            }
        }

        return result;
    }
}


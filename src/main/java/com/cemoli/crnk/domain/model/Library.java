package com.cemoli.crnk.domain.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="library")
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
//    @JoinColumn(name = "address_id")
  //  @RestResource(path = "libraryAddress", rel="address")
    private Address address;

    @OneToMany(mappedBy = "library")
    private List<Book> books;


}

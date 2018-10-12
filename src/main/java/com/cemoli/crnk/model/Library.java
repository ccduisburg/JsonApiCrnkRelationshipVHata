package com.cemoli.crnk.model;

import com.codenotfound.crnk.domain.model.Adress;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Library {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
  //  @RestResource(path = "libraryAddress", rel="address")
    private Address address;

    @OneToMany(mappedBy = "library")
    private List<Book> books;


}

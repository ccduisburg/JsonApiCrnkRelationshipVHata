package com.codenotfound.crnk.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table(name="person")
@Getter
@Setter
@MappedSuperclass
@JsonApiResource(type = "people")

public class Person implements Serializable {
  @Id
  @JsonApiId
  @Column(name="ID")
  @GeneratedValue
  private Long id;
  private String name;

//  @JsonApiRelation(opposite = "author")
//  @ElementCollection
//  private List<Article> articles = new ArrayList<>();

  public Person() {
    super();
  }

  public Person(String name) {
    this.name = name;
   // this.articles = articles;
  }





  @Override
  public String toString() {
    return "person[id=" + id + ", name=" + name + "]";
  }
}

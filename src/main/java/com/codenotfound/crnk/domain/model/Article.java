package com.codenotfound.crnk.domain.model;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonApiResource(type = "articles")
public class Article {

  @JsonApiId
  private Long id;

  private String title;

  @JsonApiRelation(opposite = "articles")
  private Person author;

  public Article() {
    super();
  }

  public Article(Long id, String title) {
    super();
    this.id = id;
    this.title = title;
  }


  @Override
  public String toString() {
    return "article[id=" + id + ", title=" + title + "]";
  }
}

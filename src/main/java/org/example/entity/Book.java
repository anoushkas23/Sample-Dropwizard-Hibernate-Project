package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
/*@NamedQueries({
    @NamedQuery(name = "Book.findByName",
        query = "SELECT b FROM Book b WHERE b.name = :name"),
    @NamedQuery(name = "Book.findAll",
        query = "SELECT b FROM Book b")
})*/
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  /*@ManyToOne
  @JoinColumn(name="fk_author_id",
      insertable=false, updatable=false,
      nullable=false)*/
  private int fk_author_id;
  private String name;
  public Book() {

  }
  public Book(String name) {
    this.name = name;
  }

  public Book(int id, String name,int fk_author_id) {
    super();
    this.id = id;
    this.fk_author_id=fk_author_id;
    this.name = name;
  }

  public int getFk_author_id() {
    return fk_author_id;
  }

  public void setFk_author_id(int fk_author_id) {
    this.fk_author_id = fk_author_id;
  }

  @JsonProperty
  public int getId() {
    return id;
  }

  @JsonProperty
  public void setId(int id) {
    this.id = id;
  }

  @JsonProperty
  public String getName() {
    return name;
  }

  @JsonProperty
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", fk_author_id=" + fk_author_id +
        ", name='" + name + '\'' +
        '}';
  }
}

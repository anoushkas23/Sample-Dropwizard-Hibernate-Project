package org.example.db;

import java.util.List;
import java.util.Optional;

import org.example.entity.Author;
import org.example.entity.Book;
public interface AuthorDAO {

  public int insert(Author toBeInserted);
  public Optional<Author> findById(int id);
  public List<Book> findBooksById(int id);
  public List<Author> findAll();
}

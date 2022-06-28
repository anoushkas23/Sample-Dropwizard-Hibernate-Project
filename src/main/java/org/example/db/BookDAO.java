package org.example.db;

import java.util.List;

import java.util.Optional;
import org.example.entity.Author;
import org.example.entity.Book;

public interface BookDAO {

  public int insert(Book toBeInserted);
  public List<Book> findAll();
  public Optional<Book> findById(int id);
}

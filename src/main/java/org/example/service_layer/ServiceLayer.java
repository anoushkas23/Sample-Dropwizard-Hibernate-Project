package org.example.service_layer;

import org.example.entity.Book;
import org.example.entity.Author;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServiceLayer {

  public int insertAuthor(Author toBeInserted);
  public Optional<Author> findAuthorById(int id);
  public List<Book> findBooksByAuthorId(int id);
  public List<Author> findAllAuthors();
  public int insertBook(Book toBeInserted);
  public List<Book> findAllBooks();
  public Optional<Book> findBookById(int id);
}

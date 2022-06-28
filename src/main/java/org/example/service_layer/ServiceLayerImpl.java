package org.example.service_layer;

import com.google.inject.Inject;
import org.example.db.BookDAO;
import org.example.db.AuthorDAO;
import org.example.entity.Author;
import org.example.entity.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceLayerImpl implements ServiceLayer{

  AuthorDAO authorDAO;
  BookDAO bookDAO;

  @Inject
  public ServiceLayerImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
    this.authorDAO = authorDAO;
    this.bookDAO = bookDAO;
  }


  @Override
  public int insertAuthor(Author toBeInserted) {
    return authorDAO.insert(toBeInserted);
  }

  @Override
  public Optional<Author> findAuthorById(int id) {
    return authorDAO.findById(id);
  }

  @Override
  public List<Book> findBooksByAuthorId(int id) {
    return authorDAO.findBooksById(id);
  }

  @Override
  public List<Author> findAllAuthors() {
    return authorDAO.findAll();
  }

  @Override
  public int insertBook(Book toBeInserted) {
    return bookDAO.insert(toBeInserted);
  }

  @Override
  public List<Book> findAllBooks() {
    return bookDAO.findAll();
  }

  @Override
  public Optional<Book> findBookById(int id) {
    return bookDAO.findById(id);
  }
}

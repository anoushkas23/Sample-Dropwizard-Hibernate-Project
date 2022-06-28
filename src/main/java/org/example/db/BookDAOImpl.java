package org.example.db;

import java.util.List;
import java.util.Optional;

import org.example.entity.Book;
import org.hibernate.SessionFactory;
import io.dropwizard.hibernate.AbstractDAO;


public class BookDAOImpl extends AbstractDAO<Book> implements BookDAO{

  //private SessionFactory sessionFactory;
  public BookDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
    //this.sessionFactory=sessionFactory;
  }

  public Optional<Book> findById(int id) {
    Book book =  currentSession().get(Book.class, id);
    return book != null ? Optional.of(book) : Optional.empty();
  }

  public List<Book> findAll() {
    return (List<Book>) currentSession().createQuery("from Book").getResultList();
  }

  public int insert(Book book) {

    persist(book);
    return book.getId();
  }
}

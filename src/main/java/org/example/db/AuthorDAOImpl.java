package org.example.db;

import org.example.entity.Author;
import org.example.entity.Book;

import java.util.List;
import java.util.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import javax.persistence.Query;

public class AuthorDAOImpl extends AbstractDAO<Author> implements AuthorDAO{

  //private SessionFactory sessionFactory;
  public AuthorDAOImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
    //this.sessionFactory=sessionFactory;
  }
  public Optional<Author> findById(int id) {
    Author author =  currentSession().get(Author.class, id);
    return author != null ? Optional.of(author) : Optional.empty();
  }
  public List<Author> findAll() {
    return (List<Author>) currentSession().createQuery("from Author").getResultList();  //same as select a from author a
  }

  public List<Book> findBooksById(int id) {

    return  currentSession().createQuery("SELECT b FROM Book b WHERE b.fk_author_id= :id")
        .setParameter("id", id)
        .getResultList();
  }

  public int insert(Author author) {

    persist(author);
    return author.getId();
  }
}

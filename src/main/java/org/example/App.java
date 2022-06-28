package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.example.db.AuthorDAOImpl;
import org.example.db.BookDAOImpl;
import org.example.db.AuthorDAO;
import org.example.db.BookDAO;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.resource.AuthorResource;
import org.example.resource.BookResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;


import io.dropwizard.setup.Environment;
import org.example.service_layer.ServiceLayer;
import org.example.service_layer.ServiceLayerImpl;
import org.example.module.AppModule;

//make requests using->
//http://localhost:8080/authors
public class App extends Application<AppConfiguration> {

  public static void main(String[] args) throws Exception {
    try {
      new App().run(args);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private final HibernateBundle<AppConfiguration> hibernate = new HibernateBundle<AppConfiguration>(Author.class,Book.class) {
    @Override
    public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
      return configuration.getDataSourceFactory();
    }
  };

  @Override
  public void initialize(Bootstrap<AppConfiguration> bootstrap) {
    bootstrap.addBundle(hibernate);
  }

/*  @Override
  public void initialize(Bootstrap<AppConfiguration> bootstrap) {
    GuiceBundle<AppConfiguration> guiceBundle = GuiceBundle.defaultBuilder(AppConfiguration.class)
        .modules(new AppModule())
        .build();

    bootstrap.addBundle(guiceBundle);
    bootstrap.addBundle(hibernate);
  }*/

  @Override
  public void run(AppConfiguration configuration, Environment environment) throws Exception {

    AuthorDAO dao1 = new AuthorDAOImpl( hibernate.getSessionFactory());
    BookDAO dao2 = new BookDAOImpl( hibernate.getSessionFactory());

    ServiceLayer serviceLayer= new ServiceLayerImpl(dao1,dao2);

    AuthorResource resource1 = new AuthorResource(serviceLayer);
    BookResource resource2 = new BookResource(serviceLayer);

    environment.jersey().register(resource1);
    environment.jersey().register(resource2);

  }

}
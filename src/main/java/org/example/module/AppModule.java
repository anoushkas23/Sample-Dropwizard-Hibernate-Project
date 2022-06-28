package org.example.module;

import com.google.inject.AbstractModule;
import org.example.service_layer.*;
import org.example.db.*;

public class AppModule extends AbstractModule {

  @Override
  protected void configure(){
    bind(ServiceLayer.class).to(ServiceLayerImpl.class);
    bind(AuthorDAO.class).to(AuthorDAOImpl.class);
    bind(BookDAO.class).to(BookDAOImpl.class);
  }
}

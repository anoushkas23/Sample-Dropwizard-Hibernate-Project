package org.example;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import javax.validation.Valid;

public class AppConfiguration extends Configuration {

/*  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }*/

  @Valid
  @NotNull
  @JsonProperty
  private DataSourceFactory database = new DataSourceFactory();

  //@JsonProperty
  public DataSourceFactory getDataSourceFactory() {
    return database;
  }

/*  public DataSourceFactory getDatabase() {
    return database;
  }

  public void setDatabase(DataSourceFactory database) {
    this.database = database;
  }*/
}

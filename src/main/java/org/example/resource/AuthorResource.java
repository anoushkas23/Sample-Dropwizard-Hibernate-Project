package org.example.resource;

import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.example.db.AuthorDAO;
import org.example.db.AuthorDAOImpl;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.service_layer.ServiceLayer;

@Path("/authors")
public class AuthorResource {

  private ServiceLayer serviceLayer;

  @Inject
  public AuthorResource(ServiceLayer serviceLayer) {
    super();
    this.serviceLayer=serviceLayer;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public Response addAuthor(@Valid Author toBeAdded) {
    int id = serviceLayer.insertAuthor(toBeAdded);
    toBeAdded.setId(id);
    return Response.created(URI.create("/authors/"+id)).entity(toBeAdded).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public List<Author> getAll(){
    return serviceLayer.findAllAuthors();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  @UnitOfWork
  public Response getById(@PathParam("id") int id) {

    Optional<Author> opt = serviceLayer.findAuthorById(id);
    if(opt.isPresent()) {
      return Response.ok(opt.get()).build();
    }else {
      throw new WebApplicationException(404);
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/books/{id}")
  @UnitOfWork
  public List<Book> getBooksById(@PathParam("id") int id) {
    return serviceLayer.findBooksByAuthorId(id);
  }
}

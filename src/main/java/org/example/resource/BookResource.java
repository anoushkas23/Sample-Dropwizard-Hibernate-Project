package org.example.resource;

import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.Optional;
import javax.validation.Valid;
import org.example.db.BookDAO;
import org.example.db.BookDAOImpl;
import org.example.entity.Author;
import org.example.entity.Book;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.example.service_layer.ServiceLayer;

@Path("/books")
public class BookResource  {
  private ServiceLayer serviceLayer;

  @Inject
  public BookResource(ServiceLayer serviceLayer) {
    super();
    this.serviceLayer=serviceLayer;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public Response addBook(@Valid  Book toBeAdded) {
    int id = serviceLayer.insertBook(toBeAdded);
    toBeAdded.setId(id);
    return Response.created(URI.create("/books/"+id)).entity(toBeAdded).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @UnitOfWork
  public List<Book> getAll(){
    return serviceLayer.findAllBooks();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  @UnitOfWork
  public Response getById(@PathParam("id") int id) {

    Optional<Book> opt = serviceLayer.findBookById(id);
    if(opt.isPresent()) {
      return Response.ok(opt.get()).build();
    }else {
      throw new WebApplicationException(404);
    }
  }

}

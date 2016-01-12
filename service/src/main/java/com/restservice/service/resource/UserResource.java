package com.restservice.service.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.restservice.common.User;
import com.restservice.service.helper.IUserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Service("userResource")
public class UserResource {

  @Inject
  IUserService userService;

  @POST
  public Response save(@Context HttpHeaders httpHeaders, User user) {
    user = userService.save(user);
    return Response.status(200).entity(user).build();
  }

  @GET
  @Path("/{id}")
  public Response get(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    return Response.status(200).entity(userService.getById(id)).build();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    // TODO: implement this
    return null;
  }
}

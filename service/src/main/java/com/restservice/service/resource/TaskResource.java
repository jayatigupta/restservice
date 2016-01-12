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

import com.restservice.common.Task;
import com.restservice.service.helper.ITaskService;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Service("taskResource")
public class TaskResource {

  @Inject
  ITaskService taskService;

  @POST
  public Response save(@Context HttpHeaders httpHeaders, Task task) {
    task = taskService.save(task);
    // TODO: handle exceptions and propagate as rest exceptions
    return Response.status(200).entity(task).build();
  }

  @GET
  public Response getAll(@Context HttpHeaders httpHeaders) {
    return Response.status(200).entity(taskService.getAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response get(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    return Response.status(200).entity(taskService.getById(id)).build();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    taskService.delete(id);
    return Response.status(200).build();
  }

  @GET
  @Path("/assign/{taskId}/{userId}")
  public Response assignTaskToUser(@Context HttpHeaders httpHeaders,
      @PathParam("taskId") String taskId, @PathParam("userId") String userId) {
    Task task = taskService.assignTaskToUser(taskId, userId);
    return Response.status(200).entity(task).build();
  }

  @Path("/fetch/{userId}")
  @POST
  public Response fetchTasksForUser(@Context HttpHeaders httpHeaders,
      @PathParam("userId") String userId) {
    return Response.status(200).entity(taskService.findAllTasksForUser(userId))
        .build();
  }
}

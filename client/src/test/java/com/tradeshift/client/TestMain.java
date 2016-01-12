package com.tradeshift.client;

import com.google.gson.Gson;
import com.restservice.client.TaskClient;
import com.restservice.client.UserClient;
import com.restservice.common.Task;
import com.restservice.common.TaskStatus;
import com.restservice.common.User;

public class TestMain {

  public static void main(String[] args) {
    String baseUrl = "http://localhost:8080/service";
    UserClient userClient = new UserClient(baseUrl+"/user");
    TaskClient taskClient = new TaskClient(baseUrl+"/task");
    Gson gson = new Gson();

    // create user
    User user = new User();
    user.setName("Jayati");
    user = userClient.save(user);
    System.out.println(gson.toJson(user));

    // create task
    Task task = new Task();
    task.setName("my task 1");
    task.setStatus(TaskStatus.OPEN);
    task = taskClient.save(task);
    System.out.println(gson.toJson(task));

    // assign user to a task
    Task taskRet = taskClient.assignUserToTask(task.getId(), user.getId());
    System.out.println(gson.toJson(taskRet));
  }
}

package com.restservice.client;

import com.restservice.common.Task;

public class TaskClient extends AbstractServiceClient implements
    IServiceClient<Task> {

  public TaskClient(String endPointUrl) {
    super(endPointUrl);
  }

  public Task save(Task task) {
    return post(endPointUrl, task, Task.class, null);
  }

  public Task getById(String id) {
    return get(endPointUrl + "/" + id, Task.class, null);
  }

  public void delete(String id) {
    delete(endPointUrl + "/" + id, String.class, null);
  }

  public Task[] getAll() {
    return get(endPointUrl, Task[].class, null);
  }

  public Task[] getAllTasksForUser(String userId) {
    return get(endPointUrl + "/fetch/" + userId, Task[].class, null);
  }

  // public Task[] getAllTasksForUserHavingStatus(String userId, TaskStatus
  // status) {
  // return get(endPointUrl, Task[].class, null);
  // }

  public Task assignUserToTask(String taskId, String userId) {
    return get(endPointUrl + "/assign/" + taskId + "/" + userId, Task.class,
        null);
  }
}

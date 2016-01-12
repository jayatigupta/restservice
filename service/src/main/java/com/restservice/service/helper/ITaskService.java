package com.restservice.service.helper;

import java.util.List;

import com.restservice.common.Task;
import com.restservice.service.entity.TaskEntity;

public interface ITaskService extends IService<Task, TaskEntity> {
  Task assignTaskToUser(String taskId, String userId);
  List<Task> findAllTasksForUser(String userId);
}

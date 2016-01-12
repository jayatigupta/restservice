package com.restservice.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.restservice.common.Task;
import com.restservice.service.dao.TaskDAO;
import com.restservice.service.dao.UserDAO;
import com.restservice.service.entity.TaskEntity;
import com.restservice.service.entity.UserEntity;

@Component
public class TaskService implements ITaskService {

  @Inject
  TaskDAO taskDAO;

  @Inject
  UserDAO userDAO;

  public Task toDTO(TaskEntity e) {
    Task dto = new Task();
    dto.setId(e.getId());
    dto.setCreatedTime(e.getCreatedAt());
    dto.setName(e.getName());
    dto.setStatus(e.getStatus());
    if (e.getTaskOwner() != null) {
      dto.setAssignedUserId(e.getTaskOwner().getId());
    }
    return dto;
  }

  public TaskEntity fromDTO(Task d, TaskEntity e) {
    if (e == null) {
      e = new TaskEntity();
      e.setId(UUID.randomUUID().toString());
    }
    e.setName(d.getName());
    e.setStatus(d.getStatus().name());
    if (d.getAssignedUserId() != null) {
      UserEntity user = userDAO.findOne(d.getAssignedUserId());
      e.setTaskOwner(user);
    }
    return e;
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Task save(Task d) {
    TaskEntity e = null;
    if (d.getId() != null) {
      e = taskDAO.getOne(d.getId());
    }
    e = fromDTO(d, e);
    taskDAO.save(e);
    return toDTO(e);
  }

  public Task getById(String id) {
    return toDTO(taskDAO.getOne(id));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void delete(String id) {
    taskDAO.delete(id);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Task assignTaskToUser(String taskId, String userId) {
    TaskEntity task = taskDAO.findOne(taskId);
    UserEntity user = userDAO.findOne(userId);
    if (task == null) {
      throw new IllegalArgumentException("task not found with id : " + taskId);
    }
    if (user == null) {
      throw new IllegalArgumentException("user not found with id : " + userId);
    }
    task.setTaskOwner(user);
    taskDAO.save(task);
    return toDTO(task);
  }

  public List<Task> findAllTasksForUser(String userId) {
    List<Task> tasksForUser = new ArrayList<>();
    UserEntity user = userDAO.findOne(userId);
    List<TaskEntity> taskEntities = taskDAO.findByTaskOwner(user);
    if (taskEntities != null && taskEntities.size() > 0) {
      for (TaskEntity e : taskEntities) {
        tasksForUser.add(toDTO(e));
      }
    }
    return tasksForUser;
  }

  public List<Task> getAll() {
    List<Task> tasks = new ArrayList<>();
    List<TaskEntity> taskEntities = taskDAO.findAll();
    if (taskEntities != null && taskEntities.size() > 0) {
      for (TaskEntity e : taskEntities) {
        tasks.add(toDTO(e));
      }
    }
    return tasks;
  }
}

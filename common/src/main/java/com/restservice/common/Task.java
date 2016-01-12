package com.restservice.common;

public class Task extends BaseDTO {
  private String name;
  private String assignedUserId;
  private TaskStatus status;
  private long createdTime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAssignedUserId() {
    return assignedUserId;
  }

  public void setAssignedUserId(String assignedUserId) {
    this.assignedUserId = assignedUserId;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public void setStatus(String status) {
    this.status = TaskStatus.valueOf(status);
  }

  public long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(long createdTime) {
    this.createdTime = createdTime;
  }
}

package com.restservice.service.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
@Access(AccessType.FIELD)
public class TaskEntity extends AbstractEntity {
  private static final long serialVersionUID = -1585439901009752704L;

  @ManyToOne(targetEntity=UserEntity.class)
  @JoinColumn(name="assignedTo", nullable=true, updatable=true)
  private UserEntity taskOwner;

  private String status;
  
  public UserEntity getTaskOwner() {
    return taskOwner;
  }

  public void setTaskOwner(UserEntity taskOwner) {
    this.taskOwner = taskOwner;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

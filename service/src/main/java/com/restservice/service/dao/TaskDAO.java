package com.restservice.service.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restservice.service.entity.TaskEntity;
import com.restservice.service.entity.UserEntity;

@Repository
public interface TaskDAO extends JpaDAO<TaskEntity, Serializable> {
  List<TaskEntity> findByTaskOwner(UserEntity taskOwner);
}

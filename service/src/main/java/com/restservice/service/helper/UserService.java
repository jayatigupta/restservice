package com.restservice.service.helper;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.restservice.common.User;
import com.restservice.service.dao.UserDAO;
import com.restservice.service.entity.UserEntity;

@Component
public class UserService implements IUserService {

  @Inject
  UserDAO userDAO;

  public User toDTO(UserEntity e) {
    if (e == null) {
      return null;
    }
    User dto = new User();
    dto.setId(e.getId());
    dto.setName(e.getName());
    return dto;
  }

  public UserEntity fromDTO(User d, UserEntity e) {
    if (e == null) {
      e = new UserEntity();
      e.setId(UUID.randomUUID().toString());
    }
    e.setName(d.getName());
    return e;
  }

  public User save(User d) {
    UserEntity e = null;
    if (d.getId() != null) {
      e = userDAO.getOne(d.getId());
    }
    e = fromDTO(d, e);
    userDAO.save(e);
    return toDTO(e);
  }

  public User getById(String id) {
    return toDTO(userDAO.findOne(id));
  }

  @Override
  public void delete(String id) {
    userDAO.delete(id);
  }

  @Override
  public List<User> getAll() {
    // TODO Auto-generated method stub
    return null;
  }
}

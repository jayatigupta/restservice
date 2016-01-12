package com.restservice.service.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.restservice.service.entity.UserEntity;

@Repository
public interface UserDAO extends JpaDAO<UserEntity, Serializable>{

}

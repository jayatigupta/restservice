package com.restservice.service.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Access(AccessType.FIELD)
public class UserEntity extends AbstractEntity {
  private static final long serialVersionUID = -2578786088362246712L;
}

package com.restservice.service.helper;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IService<DTO, ENTITY> {
  DTO toDTO(ENTITY e);
  ENTITY fromDTO(DTO d, ENTITY e);
  DTO save(DTO d);
  DTO getById(String id);
  void delete(String id);
  List<DTO> getAll();
}
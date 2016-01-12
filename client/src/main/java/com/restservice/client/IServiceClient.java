package com.restservice.client;

public interface IServiceClient<T> {
  public T save(T task);

  public T getById(String id);

  public void delete(String id);

  public T[] getAll();
}

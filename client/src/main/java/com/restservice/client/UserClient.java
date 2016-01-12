package com.restservice.client;

import com.restservice.common.User;

public class UserClient extends AbstractServiceClient implements
    IServiceClient<User> {

  public UserClient(String endPointUrl) {
    super(endPointUrl);
  }

  @Override
  public User save(User user) {
    return post(endPointUrl, user, User.class, null);
  }

  @Override
  public User getById(String id) {
    return get(endPointUrl + "/" + id, User.class, null);
  }

  @Override
  public void delete(String id) {
    delete(endPointUrl + "/" + id, String.class, null);
  }

  @Override
  public User[] getAll() {
    // TODO Auto-generated method stub
    return null;
  }

}

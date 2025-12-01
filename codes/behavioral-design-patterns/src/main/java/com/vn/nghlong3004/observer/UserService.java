package com.vn.nghlong3004.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class UserService {

  private final List<UserEventListener> listeners = new ArrayList<>();

  public void addListener(UserEventListener listener) {
    listeners.add(listener);
  }

  public User createUser(String email) {
    User user = new User(email);


    for (UserEventListener listener : listeners) {
      listener.onUserCreated(user);
    }

    return user;
  }
}

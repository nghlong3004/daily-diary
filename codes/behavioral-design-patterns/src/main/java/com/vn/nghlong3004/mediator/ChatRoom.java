package com.vn.nghlong3004.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class ChatRoom implements ChatMediator {

  private final List<User> users = new ArrayList<>();

  @Override
  public void sendMessage(String msg, User user) {
    for (User u : users) {
      if (u != user) {
        u.receive(msg);
      }
    }
  }

  @Override
  public void addUser(User user) {
    users.add(user);
  }
}

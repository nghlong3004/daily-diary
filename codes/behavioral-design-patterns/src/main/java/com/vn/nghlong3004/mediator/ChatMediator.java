package com.vn.nghlong3004.mediator;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public interface ChatMediator {
  void sendMessage(String msg, User user);

  void addUser(User user);
}

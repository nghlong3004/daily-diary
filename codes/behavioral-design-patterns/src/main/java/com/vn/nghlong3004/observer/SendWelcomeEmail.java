package com.vn.nghlong3004.observer;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class SendWelcomeEmail implements UserEventListener {
  @Override
  public void onUserCreated(User user) {
    System.out.println("Send welcome email to " + user.getEmail());
  }
}

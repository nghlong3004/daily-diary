package com.vn.nghlong3004.observer;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class CreateAuditLog implements UserEventListener {
  @Override
  public void onUserCreated(User user) {
    System.out.println("Create audit log for " + user.getEmail());
  }
}

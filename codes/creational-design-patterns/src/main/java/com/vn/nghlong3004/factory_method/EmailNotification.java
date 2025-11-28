package com.vn.nghlong3004.factory_method;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class EmailNotification implements Notification {
  public void send(String to, String message) {
    System.out.println("Send EMAIL to " + to + ": " + message);
  }
}

package com.vn.nghlong3004.factory_method;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args){
    NotificationFactory emailFactory = new EmailNotificationFactory();

    Notification emailNotification = emailFactory.create();

  }
}

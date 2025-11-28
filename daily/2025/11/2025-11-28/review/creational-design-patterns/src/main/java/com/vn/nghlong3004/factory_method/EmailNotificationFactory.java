package com.vn.nghlong3004.factory_method;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class EmailNotificationFactory implements NotificationFactory{
  @Override
  public Notification create() {
    return new EmailNotification();
  }
}

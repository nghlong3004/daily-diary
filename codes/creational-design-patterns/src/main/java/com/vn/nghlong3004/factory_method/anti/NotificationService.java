package com.vn.nghlong3004.factory_method.anti;

import com.vn.nghlong3004.factory_method.EmailNotification;
import com.vn.nghlong3004.factory_method.Notification;
import com.vn.nghlong3004.factory_method.SmsNotification;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class NotificationService {

  public void notify(String type, String to, String message) {
    Notification notification;
    if ("EMAIL".equals(type)) {
      notification = new EmailNotification();
    } else if ("SMS".equals(type)) {
      notification = new SmsNotification();
    } else {
      throw new IllegalArgumentException("Unsupported type");
    }

    notification.send(to, message);
  }
}


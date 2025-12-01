package com.vn.nghlong3004.observer;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args){
    UserService service = new UserService();
    service.addListener(new SendWelcomeEmail());
    service.addListener(new CreateAuditLog());

    service.createUser("nghlong3004@gmail.com");
  }
}

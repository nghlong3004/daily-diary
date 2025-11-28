package com.vn.nghlong3004.prototype;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args) throws CloneNotSupportedException {
    User user1 = new User("Long", new Address("HN"));
    User user2 = user1.clone();

    user2.getAddress().setStreet("HCM");

    System.out.println(user1.getAddress().getStreet());
  }
}

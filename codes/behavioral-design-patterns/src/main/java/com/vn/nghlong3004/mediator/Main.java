package com.vn.nghlong3004.mediator;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Main {
  public static void main(String[] args) {
    ChatMediator mediator = new ChatRoom();

    User user1 = new ChatUser(mediator, "1");
    User user2 = new ChatUser(mediator, "2");
    User user3 = new ChatUser(mediator, "3");

    mediator.addUser(user1);
    mediator.addUser(user2);
    mediator.addUser(user3);

    user1.send("Hello ace!");
  }
}

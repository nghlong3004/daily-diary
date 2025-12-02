package com.vn.nghlong3004.mediator;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class ChatUser extends User {

  public ChatUser(ChatMediator mediator, String name) {
    super(mediator, name);
  }

  @Override
  public void send(String msg) {
    mediator.sendMessage(msg, this);
  }

  @Override
  public void receive(String msg) {
    System.out.println(this.name + " receive: " + msg);
  }
}

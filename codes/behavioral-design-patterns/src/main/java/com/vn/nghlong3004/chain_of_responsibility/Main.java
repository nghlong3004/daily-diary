package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args) {
    Request request = new Request();
    Handler chain = new AuthHandler();
    chain.setNext(new RoleHandler()).setNext(new LoggingHandler());

    chain.handle(request);
  }
}

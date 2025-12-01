package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args) {
    Order order = new Order();

    order.pay();
    order.ship();
    order.deliver();
  }
}

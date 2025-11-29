package com.vn.nghlong3004.facade;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    OrderFacade facade = new OrderFacade();
    facade.placeOrder("Long", "P123", 150000, "Ha Noi");
  }
}

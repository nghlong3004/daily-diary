package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public interface OrderState {
  void pay(Order order);
  void ship(Order order);
  void deliver(Order order);
}
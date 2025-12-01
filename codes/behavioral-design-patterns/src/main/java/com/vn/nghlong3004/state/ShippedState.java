package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class ShippedState implements OrderState {
  @Override
  public void pay(Order order) {
    System.out.println("Đã thanh toán rồi");
  }

  @Override
  public void ship(Order order) {
    System.out.println("Đang ship rồi");
  }

  @Override
  public void deliver(Order order) {
    order.setState(new DeliveredState());
  }
}

package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class PendingState implements OrderState {

  @Override
  public void pay(Order order) {
    System.out.println("Order đã thanh toán");
    order.setState(new PaidState());
  }

  @Override
  public void ship(Order order) {
    System.out.println("Không thể ship khi chưa thanh toán");
  }

  @Override
  public void deliver(Order order) {
    System.out.println("Chưa thể giao hàng khi chưa ship");
  }
}

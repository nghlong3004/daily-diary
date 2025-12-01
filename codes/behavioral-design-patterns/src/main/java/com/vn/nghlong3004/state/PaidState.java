package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class PaidState implements OrderState {

  @Override
  public void pay(Order order) {
    System.out.println("Đã thanh toán rồi!");
  }

  @Override
  public void ship(Order order) {
    System.out.println("Đang ship đơn hàng");
    order.setState(new ShippedState());
  }

  @Override
  public void deliver(Order order) {
    System.out.println("Chưa thể giao khi chưa ship");
  }
}

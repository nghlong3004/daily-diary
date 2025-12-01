package com.vn.nghlong3004.state;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Order {

  private OrderState state = new PendingState();

  public void setState(OrderState state) {
    this.state = state;
  }

  public void pay() {
    state.pay(this);
  }

  public void ship() {
    state.ship(this);
  }

  public void deliver() {
    state.deliver(this);
  }
}

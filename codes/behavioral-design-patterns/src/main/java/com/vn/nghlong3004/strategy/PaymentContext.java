package com.vn.nghlong3004.strategy;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class PaymentContext {
  private PaymentStrategy strategy;

  public PaymentContext(PaymentStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(PaymentStrategy strategy) {
    this.strategy = strategy;
  }

  public void checkout(int amount) {
    strategy.pay(amount);
  }
}


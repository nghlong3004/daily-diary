package com.vn.nghlong3004.decorator;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class ValidationPaymentDecorator extends PaymentDecorator {

  public ValidationPaymentDecorator(PaymentService wrapped) {
    super(wrapped);
  }

  @Override
  public void pay(String from, String to, long amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Invalid amount");
    }
    wrapped.pay(from, to, amount);
  }
}

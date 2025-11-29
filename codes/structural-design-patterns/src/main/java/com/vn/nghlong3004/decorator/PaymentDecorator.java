package com.vn.nghlong3004.decorator;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public abstract class PaymentDecorator implements PaymentService {
  protected final PaymentService wrapped;

  public PaymentDecorator(PaymentService wrapped) {
    this.wrapped = wrapped;
  }
}

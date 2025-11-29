package com.vn.nghlong3004.decorator;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class LoggingPaymentDecorator extends PaymentDecorator {

  public LoggingPaymentDecorator(PaymentService wrapped) {
    super(wrapped);
  }

  @Override
  public void pay(String from, String to, long amount) {
    System.out.println("[LOG] start payment...");
    wrapped.pay(from, to, amount);
    System.out.println("[LOG] end payment.");
  }
}

package com.vn.nghlong3004.decorator;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class BasicPaymentService implements PaymentService {
  @Override
  public void pay(String from, String to, long amount) {
    System.out.println("Paying " + amount + " from " + from + " to " + to);
  }
}

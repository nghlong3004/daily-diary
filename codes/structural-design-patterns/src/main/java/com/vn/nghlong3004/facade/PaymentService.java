package com.vn.nghlong3004.facade;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class PaymentService {
  public void pay(String user, long amount) {
    System.out.println("Paying " + amount + " from " + user);
  }
}

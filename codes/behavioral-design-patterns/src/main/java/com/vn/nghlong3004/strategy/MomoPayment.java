package com.vn.nghlong3004.strategy;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class MomoPayment implements PaymentStrategy {
  @Override
  public void pay(int amount) {
    System.out.println("Pay: " + amount + " by Momo");
  }
}


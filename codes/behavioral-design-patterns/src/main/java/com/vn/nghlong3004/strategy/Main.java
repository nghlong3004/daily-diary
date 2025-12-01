package com.vn.nghlong3004.strategy;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args) {
    PaymentContext context = new PaymentContext(new MomoPayment());
    context.checkout(100);

    context.setStrategy(new VnPayPayment());
    context.checkout(200);

    context.setStrategy(new CashPayment());
    context.checkout(50);
  }

}

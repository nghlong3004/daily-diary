package com.vn.nghlong3004.adapter;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class PaymentService {

  private final PaymentGateway paymentGateway;

  public PaymentService(PaymentGateway paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  public void processOrder(String buyerIban, String shopIban, long totalPrice) {
    paymentGateway.pay(buyerIban, shopIban, totalPrice);
  }
}


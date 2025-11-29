package com.vn.nghlong3004.adapter;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public interface PaymentGateway {
  void pay(String fromAccount, String toAccount, long amountInVnd);
}

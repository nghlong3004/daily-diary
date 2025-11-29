package com.vn.nghlong3004.adapter;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    OldBankApi oldBankApi = new OldBankApi();
    PaymentGateway gateway = new OldBankPaymentAdapter(oldBankApi);
    PaymentService service = new PaymentService(gateway);

    service.processOrder("IBAN_BUYER_123", "IBAN_SHOP_999", 500_000);
  }
}

package com.vn.nghlong3004.adapter;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class OldBankPaymentAdapter implements PaymentGateway {

  private final OldBankApi oldBankApi;

  public OldBankPaymentAdapter(OldBankApi oldBankApi) {
    this.oldBankApi = oldBankApi;
  }

  @Override
  public void pay(String fromAccount, String toAccount, long amountInVnd) {
    double amount = (double) amountInVnd;
    oldBankApi.makeTransfer(fromAccount, toAccount, amount);
  }
}

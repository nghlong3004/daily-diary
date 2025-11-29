package com.vn.nghlong3004.adapter;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class OldBankApi {

  public void makeTransfer(String sourceIban, String destIban, double amountInVnd) {
    System.out.println("OldBank transfer " + amountInVnd +
            " VND from " + sourceIban + " to " + destIban);
  }
}

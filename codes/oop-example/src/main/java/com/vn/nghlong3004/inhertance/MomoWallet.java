package com.vn.nghlong3004.inhertance;

import com.vn.nghlong3004.abstraction.Wallet;

/**
 * Project: oop-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class MomoWallet extends Wallet {
  public MomoWallet(double initialBalance) {
    super(initialBalance);
  }

  @Override
  public void pay(double amount){
    super.pay(amount + 1000);
  }
}

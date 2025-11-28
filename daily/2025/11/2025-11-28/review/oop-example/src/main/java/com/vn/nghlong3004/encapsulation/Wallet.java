package com.vn.nghlong3004.encapsulation;

/**
 * Project: oop-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */

public class Wallet {
  private double balance;

  public double getBalance() {
    return balance;
  }
  public Wallet(double initialBalance) {
    if(initialBalance < 0){
      throw new IllegalArgumentException("Balance cannot be less than 0");
    }
    this.balance = initialBalance;
  }
  public void pay(double amount) {

    if (this.getBalance() >= amount) {
      double newBalance = this.getBalance() - amount;

      this.setBalance(newBalance);

      System.out.println("Successfully");
    } else {
      System.out.println("False");
    }

  }
  // Data hiding
  private void setBalance(double balance) {

    this.balance = balance;

  }
}

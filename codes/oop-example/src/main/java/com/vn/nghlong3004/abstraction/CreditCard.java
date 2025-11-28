package com.vn.nghlong3004.abstraction;

/**
 * Project: oop-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class CreditCard implements Payment{

  private double debt;

  public CreditCard(double initialDebt) {
    this.debt = initialDebt;
  }

  @Override
  public void pay(double amount) {
    double newBalance = this.getDebt() + amount;
    this.setDebt(newBalance);
    System.out.println("Quẹt thẻ xong. Nợ hiện tại: " + this.getDebt());
  }

  private void setDebt(double debt){
    this.debt = debt;
  }

  public double getDebt(){
    return this.debt;
  }
}

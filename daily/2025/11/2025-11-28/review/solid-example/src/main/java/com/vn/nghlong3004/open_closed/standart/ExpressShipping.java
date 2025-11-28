package com.vn.nghlong3004.open_closed.standart;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ExpressShipping implements ShippingStrategy {
  @Override
  public int calculateFee(int basePrice) {
    return basePrice + 30_000;
  }
}

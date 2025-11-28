package com.vn.nghlong3004.open_closed.standart;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ShippingFeeCalculator {

  private final ShippingStrategy shippingStrategy;

  public ShippingFeeCalculator(ShippingStrategy shippingStrategy) {
    this.shippingStrategy = shippingStrategy;
  }

  public int calculateFee(int basePrice) {
    return shippingStrategy.calculateFee(basePrice);
  }
}

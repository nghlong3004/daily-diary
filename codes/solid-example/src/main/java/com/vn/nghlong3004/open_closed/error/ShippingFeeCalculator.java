package com.vn.nghlong3004.open_closed.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ShippingFeeCalculator {

  public int calculateFee(String shippingType, int basePrice) {
    return switch (shippingType) {
      case "STANDARD" -> basePrice + 10_000;
      case "EXPRESS" -> basePrice + 30_000;
      case "SAME_DAY" -> basePrice + 50_000;
      default -> throw new IllegalArgumentException("Unknown shipping type");
    };
  }

}

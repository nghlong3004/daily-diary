package com.vn.nghlong3004;

import com.vn.nghlong3004.open_closed.standart.ExpressShipping;
import com.vn.nghlong3004.open_closed.standart.ShippingFeeCalculator;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args) {
    var calculator =
            new ShippingFeeCalculator(new ExpressShipping());

    int fee = calculator.calculateFee(100_000);

  }
}
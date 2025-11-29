package com.vn.nghlong3004.facade;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class ShippingService {
  public void ship(String productId, String address) {
    System.out.println("Shipping " + productId + " to " + address);
  }
}

package com.vn.nghlong3004.facade;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class OrderFacade {

  private final InventoryService inventory;
  private final PaymentService payment;
  private final ShippingService shipping;

  public OrderFacade() {
    this.inventory = new InventoryService();
    this.payment = new PaymentService();
    this.shipping = new ShippingService();
  }

  public void placeOrder(String user, String productId, long amount, String address) {
    if (!inventory.checkStock(productId)) {
      throw new RuntimeException("Out of stock");
    }

    payment.pay(user, amount);
    shipping.ship(productId, address);

    System.out.println("Order completed!");
  }
}

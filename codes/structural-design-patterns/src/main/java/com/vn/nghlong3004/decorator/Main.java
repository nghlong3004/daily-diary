package com.vn.nghlong3004.decorator;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    PaymentService service =
            new LoggingPaymentDecorator(
                    new ValidationPaymentDecorator(
                            new BasicPaymentService()
                    )
            );

    service.pay("A123", "B999", 1000);
  }
}

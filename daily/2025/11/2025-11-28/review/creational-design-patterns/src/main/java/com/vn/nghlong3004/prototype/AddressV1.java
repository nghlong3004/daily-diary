package com.vn.nghlong3004.prototype;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class AddressV1 {
  private String street;

  public AddressV1(String street) {
    this.street = street;
  }

  public AddressV1 copy() {
    return new AddressV1(street);
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}

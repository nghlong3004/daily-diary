package com.vn.nghlong3004.prototype;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Address implements Cloneable {
  private String street;

  public Address(String street) {
    this.street = street;
  }

  @Override
  public Address clone() throws CloneNotSupportedException {
    Address address = (Address) super.clone();
    return new Address(this.street);
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}

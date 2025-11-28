package com.vn.nghlong3004.prototype;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UserV1 {
  private final String name;
  private final AddressV1 address;

  public UserV1(String name, AddressV1 address) {
    this.name = name;
    this.address = address;
  }

  public UserV1 copy() {
    return new UserV1(name, address.copy());
  }
}

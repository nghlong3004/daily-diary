package com.vn.nghlong3004.prototype;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class User implements Cloneable {
  private String name;
  private Address address;

  public User(String name, Address address) {
    this.name = name;
    this.address = address;
  }

  @Override
  public User clone() throws CloneNotSupportedException {
    User user = (User) super.clone();
    return new User(this.name, this.address.clone());
  }

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}

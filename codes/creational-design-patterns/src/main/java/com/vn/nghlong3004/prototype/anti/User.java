package com.vn.nghlong3004.prototype.anti;

import com.vn.nghlong3004.prototype.Address;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
class User implements Cloneable {
  String name;
  Address address;

  @Override
  public User clone() throws CloneNotSupportedException {
    return (User) super.clone();
  }
}

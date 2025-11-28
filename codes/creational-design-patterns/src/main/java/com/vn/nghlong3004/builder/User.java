package com.vn.nghlong3004.builder;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class User {
  private String name;
  private String email;
  private Integer age;
  private String address;

  private User(Builder builder) {
    this.name = builder.name;
    this.email = builder.email;
    this.age = builder.age;
    this.address = builder.address;
  }

  public static class Builder {
    private String name;
    private String email;
    private Integer age;
    private String address;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }
}


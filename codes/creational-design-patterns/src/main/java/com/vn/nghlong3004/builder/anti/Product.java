package com.vn.nghlong3004.builder.anti;

import java.math.BigDecimal;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Product {
  public String name;
  public BigDecimal price;
  public String description;
  public String category;
  public String manufacturer;
  public boolean active;
  public String barcode;

  public Product(String name, BigDecimal price, String description, String category,
                 String manufacturer, boolean active, String barcode) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.manufacturer = manufacturer;
    this.active = active;
    this.barcode = barcode;
  }
}


package com.vn.nghlong3004.liskov_substitution.standrard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Rectangle implements Shape {
  private final int width;
  private final int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public int area() {
    return width * height;
  }
}

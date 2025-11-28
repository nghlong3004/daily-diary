package com.vn.nghlong3004.liskov_substitution.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Rectangle {
  protected int width;
  protected int height;

  public void setWidth(int width) { this.width = width; }
  public void setHeight(int height) { this.height = height; }

  public int area() {
    return width * height;
  }
}

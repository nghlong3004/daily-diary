package com.vn.nghlong3004.liskov_substitution.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Square extends Rectangle {

  @Override
  public void setWidth(int width) {
    this.width = width;
    this.height = width;
  }

  @Override
  public void setHeight(int height) {
    this.width = height;
    this.height = height;
  }
}

package com.vn.nghlong3004.liskov_substitution.standrard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Square implements Shape {
  private final int edge;

  public Square(int edge) {
    this.edge = edge;
  }

  @Override
  public int area() {
    return edge * edge;
  }
}

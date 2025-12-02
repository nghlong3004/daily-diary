package com.vn.nghlong3004.visitor;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Circle implements Shape {
  public int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visit(this);
  }
}

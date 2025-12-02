package com.vn.nghlong3004.visitor;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Rectangle implements Shape {
  public int width;
  public int height;

  public Rectangle(int w, int h) {
    this.width = w;
    this.height = h;
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visit(this);
  }
}

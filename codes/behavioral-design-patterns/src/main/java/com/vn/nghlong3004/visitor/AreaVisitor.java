package com.vn.nghlong3004.visitor;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class AreaVisitor implements ShapeVisitor {

  @Override
  public void visit(Circle circle) {
    double area = Math.PI * circle.radius * circle.radius;
    System.out.println("Circle area: " + area);
  }

  @Override
  public void visit(Rectangle rectangle) {
    int area = rectangle.width * rectangle.height;
    System.out.println("Rectangle area: " + area);
  }
}

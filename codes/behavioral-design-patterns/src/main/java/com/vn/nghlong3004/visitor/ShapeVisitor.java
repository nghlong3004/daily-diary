package com.vn.nghlong3004.visitor;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public interface ShapeVisitor {
  void visit(Circle circle);

  void visit(Rectangle rectangle);
}

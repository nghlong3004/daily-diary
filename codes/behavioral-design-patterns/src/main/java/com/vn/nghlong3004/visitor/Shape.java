package com.vn.nghlong3004.visitor;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public interface Shape {
  void accept(ShapeVisitor visitor);
}

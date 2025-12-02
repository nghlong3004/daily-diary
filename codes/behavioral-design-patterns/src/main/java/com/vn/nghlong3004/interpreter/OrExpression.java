package com.vn.nghlong3004.interpreter;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class OrExpression implements Expression {

  private Expression left;
  private Expression right;

  public OrExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean interpret(String context) {
    return left.interpret(context) || right.interpret(context);
  }
}

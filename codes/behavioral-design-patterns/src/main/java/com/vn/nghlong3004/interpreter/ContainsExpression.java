package com.vn.nghlong3004.interpreter;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class ContainsExpression implements Expression {
  private String keyword;

  public ContainsExpression(String keyword) {
    this.keyword = keyword;
  }

  @Override
  public boolean interpret(String context) {
    return context.contains(keyword);
  }
}

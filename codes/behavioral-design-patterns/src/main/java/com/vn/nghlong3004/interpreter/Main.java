package com.vn.nghlong3004.interpreter;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Main {
  public static void main(String[] args) {
    Expression exp =
        new OrExpression(new ContainsExpression("Java"), new ContainsExpression("Spring"));

    System.out.println(exp.interpret("I love Java"));
    System.out.println(exp.interpret("I love React"));
  }
}

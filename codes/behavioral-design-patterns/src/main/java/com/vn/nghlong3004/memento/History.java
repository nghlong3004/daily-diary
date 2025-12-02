package com.vn.nghlong3004.memento;

import java.util.Stack;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class History {
  private Stack<Memento> stack = new Stack<>();

  public void push(Memento m) {
    stack.push(m);
  }

  public Memento pop() {
    return stack.pop();
  }
}

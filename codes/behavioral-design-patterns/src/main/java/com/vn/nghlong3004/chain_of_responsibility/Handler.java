package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public abstract class Handler {
  private Handler next;

  public Handler setNext(Handler next) {
    this.next = next;
    return next;
  }

  public void handle(Request request) {
    if (next != null) {
      next.handle(request);
    }
  }
}

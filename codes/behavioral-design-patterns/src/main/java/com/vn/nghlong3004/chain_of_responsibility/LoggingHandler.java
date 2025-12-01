package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class LoggingHandler extends Handler {
  @Override
  public void handle(Request request) {
    System.out.println("Log request: " + request);
    super.handle(request);
  }
}

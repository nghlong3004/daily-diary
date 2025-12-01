package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class AuthHandler extends Handler {
  @Override
  public void handle(Request request) {
    if (!request.isAuthenticated()) {
      throw new RuntimeException("Unauthenticated");
    }
    super.handle(request);
  }
}

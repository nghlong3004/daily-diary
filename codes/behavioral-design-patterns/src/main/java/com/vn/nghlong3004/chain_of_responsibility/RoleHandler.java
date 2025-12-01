package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class RoleHandler extends Handler {
  @Override
  public void handle(Request request) {
    if (!request.hasRole("ADMIN")) {
      throw new RuntimeException("Forbidden");
    }
    super.handle(request);
  }
}

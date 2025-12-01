package com.vn.nghlong3004.chain_of_responsibility;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Request {
  public boolean isAuthenticated() {
    return true;
  }

  public boolean hasRole(String role) {
    return "ADMIN".equals(role);
  }
}

package com.vn.nghlong3004.dependency_inversion.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class MySqlUserRepository {
  public void save(String email) {
    System.out.println("Save user to MySQL: " + email);
  }
}


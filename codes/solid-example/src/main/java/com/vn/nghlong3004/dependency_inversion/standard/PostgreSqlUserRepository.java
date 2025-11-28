package com.vn.nghlong3004.dependency_inversion.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class PostgreSqlUserRepository implements UserRepository {
  @Override
  public void save(String email) {
    System.out.println("Save user to PostgreSQL: " + email);
  }
}

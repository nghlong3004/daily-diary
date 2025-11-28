package com.vn.nghlong3004.dependency_inversion.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UserRegistrationService {

  private final MySqlUserRepository userRepository = new MySqlUserRepository();

  public void register(String email) {
    // validate, hash password, etc ...

    // User dependency hard-core MySqlUserRepository -> if switch to
    // PostgreSQLUserRepository -> change code -> error Dependency Inversion
    userRepository.save(email);
  }
}

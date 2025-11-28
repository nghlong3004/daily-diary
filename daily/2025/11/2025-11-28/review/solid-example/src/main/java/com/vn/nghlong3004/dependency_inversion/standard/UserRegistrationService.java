package com.vn.nghlong3004.dependency_inversion.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UserRegistrationService {

  private final UserRepository userRepository;

  public UserRegistrationService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void register(String email) {
    // validate...
    userRepository.save(email);
  }
}

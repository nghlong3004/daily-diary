package com.vn.nghlong3004.single_responsibility.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UserService {
  public void registerUser(String email, String password) {
    // 1. Validate input
    if (!email.contains("@")) {
      throw new IllegalArgumentException("Invalid email");
    }

    // 2. Hash password
    String hashedPassword = hashPassword(password);

    // 3. Save user in DB
    System.out.println("Saving user to DB: " + email + ", " + hashedPassword);

    // 4. Sending email welcome
    System.out.println("Sending welcome email to " + email);
  }

  private String hashPassword(String rawPassword) {
    return "HASHED_" + rawPassword;
  }
}

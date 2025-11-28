package com.vn.nghlong3004.single_responsibility.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UserService {

  private final EmailSender sender;
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  public UserService(EmailSender sender, PasswordEncoder passwordEncoder, UserRepository userRepository) {
    this.sender = sender;
    this.passwordEncoder = passwordEncoder;
    this.userRepository = userRepository;
  }

  public void register(String email, String password){
    // 1. Validate input
    validation(email);
    // 2. Hash password
    String passwordHash = passwordEncoder.hashPassword(password);
    // 3. Save in DB
    userRepository.save(email);
    // 4. Sending email welcome
    sender.send("Sending welcome email to " + email);
  }

  private void validation(String email){
    System.out.println("Validation email: " + email);
  }

}

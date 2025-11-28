package com.vn.nghlong3004.dependency_inversion.standard;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args){
    UserRepository repository = new MySqlUserRepository();
    // Or switch:
    // repository = new PostgresUserRepository();

    UserRegistrationService service = new UserRegistrationService(repository);
    service.register("test@example.com");
  }
}

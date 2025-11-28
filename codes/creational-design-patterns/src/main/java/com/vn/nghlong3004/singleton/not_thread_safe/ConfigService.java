package com.vn.nghlong3004.singleton.not_thread_safe;

/**
 * Project: singleton-pattern
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ConfigService {
  private static ConfigService instance;

  private ConfigService() {
  }

  public static ConfigService getInstance() {
    if (instance == null) {
      instance = new ConfigService();
    }
    return instance;
  }
}

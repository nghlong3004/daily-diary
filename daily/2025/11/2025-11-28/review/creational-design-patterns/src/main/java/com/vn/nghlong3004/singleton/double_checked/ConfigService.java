package com.vn.nghlong3004.singleton.double_checked;

/**
 * Project: singleton-pattern
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ConfigService {
  private static volatile ConfigService instance;

  private ConfigService() {
  }

  public static ConfigService getInstance() {
    if (instance == null) {
      synchronized (ConfigService.class) {
        if (instance == null) {
          instance = new ConfigService();
        }
      }
    }
    return instance;
  }
}


package com.vn.nghlong3004.singleton.enum_singleton;

/**
 * Project: singleton-pattern
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public enum ConfigService {
  INSTANCE;

  public String get(String key) {
    return "value";
  }
}


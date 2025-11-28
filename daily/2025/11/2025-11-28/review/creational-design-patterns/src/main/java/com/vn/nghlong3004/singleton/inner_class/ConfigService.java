package com.vn.nghlong3004.singleton.inner_class;

/**
 * Project: singleton-pattern
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class ConfigService {

  private ConfigService() {
  }

  private static class Holder {
    private static final ConfigService INSTANCE = new ConfigService();
  }

  public static ConfigService getInstance() {
    return Holder.INSTANCE;
  }
}


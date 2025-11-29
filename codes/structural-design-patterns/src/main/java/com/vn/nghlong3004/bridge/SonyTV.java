package com.vn.nghlong3004.bridge;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class SonyTV implements Device {

  @Override
  public void powerOn() {
    System.out.println("SonyTV powered ON");
  }

  @Override
  public void powerOff() {
    System.out.println("SonyTV powered OFF");
  }

  @Override
  public void setVolume(int level) {
    System.out.println("SonyTV volume set to " + level);
  }
}


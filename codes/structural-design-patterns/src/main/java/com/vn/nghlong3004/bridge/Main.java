package com.vn.nghlong3004.bridge;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    Device tv = new SonyTV();

    Remote remote = new AdvancedRemote(tv);

    remote.turnOn();
    ((AdvancedRemote) remote).mute();
    remote.turnOff();
  }
}


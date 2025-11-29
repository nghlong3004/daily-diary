package com.vn.nghlong3004.bridge;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public abstract class Remote {

  protected Device device;

  public Remote(Device device) {
    this.device = device;
  }

  public void turnOn() {
    device.powerOn();
  }

  public void turnOff() {
    device.powerOff();
  }
}


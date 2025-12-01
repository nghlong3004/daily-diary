package com.vn.nghlong3004.command;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args) {
    Light light = new Light();
    RemoteControl remote = new RemoteControl();

    remote.submit(new TurnOnLightCommand(light));
    remote.undo();
  }
}

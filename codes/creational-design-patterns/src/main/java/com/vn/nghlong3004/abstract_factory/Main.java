package com.vn.nghlong3004.abstract_factory;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args) {
    UIFactory factory = new DarkUIFactory();
    Application app = new Application(factory);
    app.render();
  }
}

package com.vn.nghlong3004.abstract_factory;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class DarkUIFactory implements UIFactory {
  public Button createButton() {
    return new DarkButton();
  }

  public Textbox createTextbox() {
    return new DarkTextbox();
  }
}

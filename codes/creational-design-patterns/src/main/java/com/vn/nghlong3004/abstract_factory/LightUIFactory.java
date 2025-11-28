package com.vn.nghlong3004.abstract_factory;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class LightUIFactory implements UIFactory {
  public Button createButton() {
    return new LightButton();
  }

  public Textbox createTextbox() {
    return new LightTextbox();
  }
}

package com.vn.nghlong3004.abstract_factory;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Application {

  private final Button button;
  private final Textbox textbox;

  public Application(UIFactory factory) {
    this.button = factory.createButton();
    this.textbox = factory.createTextbox();
  }

  public void render() {
    button.render();
    textbox.render();
  }
}

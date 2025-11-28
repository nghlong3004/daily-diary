package com.vn.nghlong3004.abstract_factory.anti;

import com.vn.nghlong3004.abstract_factory.*;

/**
 * Project: creational-design-patterns
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class UIComponentFactory {
  public Button createButton(String theme) {
    if (theme.equals("dark")) return new DarkButton();
    if (theme.equals("light")) return new LightButton();
    return null;
  }

  public Textbox createTextbox(String theme) {
    if (theme.equals("dark")) return new DarkTextbox();
    if (theme.equals("light")) return new LightTextbox();
    return null;
  }
}

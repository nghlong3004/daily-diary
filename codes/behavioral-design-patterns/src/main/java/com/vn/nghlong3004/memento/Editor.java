package com.vn.nghlong3004.memento;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Editor {
  private String text;

  public void setText(String text) {
    this.text = text;
  }

  public Memento save() {
    return new Memento(text);
  }

  public void restore(Memento memento) {
    this.text = memento.getState();
  }

  public String getText() {
    return text;
  }
}

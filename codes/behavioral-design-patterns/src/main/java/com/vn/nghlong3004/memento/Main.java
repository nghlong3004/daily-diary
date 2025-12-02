package com.vn.nghlong3004.memento;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Main {
  public static void main(String[] args) {
    Editor editor = new Editor();
    History history = new History();

    editor.setText("L1");
    history.push(editor.save());

    editor.setText("L2");
    history.push(editor.save());

    editor.setText("L3");

    editor.restore(history.pop());
    editor.restore(history.pop());
  }
}

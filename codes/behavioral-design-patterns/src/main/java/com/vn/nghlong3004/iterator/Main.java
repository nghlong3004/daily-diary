package com.vn.nghlong3004.iterator;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class Main {
  public static void main(String[] args) {
    WordsCollection wc = new WordsCollection();
    wc.addItem("Long");
    wc.addItem("learning");
    wc.addItem("Design Patterns");

    Iterator<String> iterator = wc.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

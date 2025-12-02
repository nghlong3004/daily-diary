package com.vn.nghlong3004.iterator;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class WordsIterator implements Iterator<String> {

  private final WordsCollection collection;
  private int index = 0;

  public WordsIterator(WordsCollection collection) {
    this.collection = collection;
  }

  @Override
  public boolean hasNext() {
    return index < collection.getItems().size();
  }

  @Override
  public String next() {
    return collection.getItems().get(index++);
  }
}

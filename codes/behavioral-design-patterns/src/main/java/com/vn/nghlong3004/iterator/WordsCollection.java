package com.vn.nghlong3004.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/2/2025
 */
public class WordsCollection implements IterableCollection<String> {

  private final List<String> items = new ArrayList<>();

  public void addItem(String word) {
    items.add(word);
  }

  @Override
  public Iterator<String> iterator() {
    return new WordsIterator(this);
  }

  public List<String> getItems() {
    return items;
  }
}

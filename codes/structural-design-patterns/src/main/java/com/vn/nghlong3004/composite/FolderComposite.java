package com.vn.nghlong3004.composite;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
import java.util.ArrayList;
import java.util.List;

public class FolderComposite implements FileComponent {

  private final String name;
  private final List<FileComponent> children = new ArrayList<>();

  public FolderComposite(String name) {
    this.name = name;
  }

  public void add(FileComponent component) {
    children.add(component);
  }

  @Override
  public long getSize() {
    long total = 0;
    for (FileComponent c : children) {
      total += c.getSize();
    }
    return total;
  }

  @Override
  public void show() {
    System.out.println("Folder: " + name);
    for (FileComponent c : children) {
      c.show();
    }
  }
}


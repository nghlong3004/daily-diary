package com.vn.nghlong3004.composite;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class FileLeaf implements FileComponent {

  private final String name;
  private final long size;

  public FileLeaf(String name, long size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public long getSize() {
    return size;
  }

  @Override
  public void show() {
    System.out.println("File: " + name + " (" + size + " bytes)");
  }
}

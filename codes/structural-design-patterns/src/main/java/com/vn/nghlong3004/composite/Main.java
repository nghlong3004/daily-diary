package com.vn.nghlong3004.composite;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {

    FileComponent file1 = new FileLeaf("a.txt", 1200);
    FileComponent file2 = new FileLeaf("b.jpg", 8000);

    FolderComposite folder = new FolderComposite("Photos");
    folder.add(file1);
    folder.add(file2);

    folder.show();
    System.out.println("Total size = " + folder.getSize());
  }
}


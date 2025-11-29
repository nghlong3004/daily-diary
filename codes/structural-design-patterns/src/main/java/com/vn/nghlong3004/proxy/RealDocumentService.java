package com.vn.nghlong3004.proxy;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class RealDocumentService implements DocumentService {

  @Override
  public void readDocument(String user) {
    System.out.println(user + " is reading the document...");
  }
}

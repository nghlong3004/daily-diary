package com.vn.nghlong3004.proxy;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class DocumentServiceProxy implements DocumentService {

  private final RealDocumentService realService = new RealDocumentService();

  @Override
  public void readDocument(String user) {
    if (!user.equals("admin")) {
      throw new RuntimeException("Access denied!");
    }
    System.out.println("Access granted!");
    realService.readDocument(user);
  }
}

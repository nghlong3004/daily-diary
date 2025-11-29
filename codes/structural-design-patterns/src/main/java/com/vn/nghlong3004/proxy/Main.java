package com.vn.nghlong3004.proxy;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    DocumentService service = new DocumentServiceProxy();

    service.readDocument("guest");
    service.readDocument("admin");
  }
}

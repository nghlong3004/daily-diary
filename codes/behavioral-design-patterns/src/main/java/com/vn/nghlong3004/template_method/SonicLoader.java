package com.vn.nghlong3004.template_method;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class SonicLoader extends GameLoader {
  @Override
  protected void init() {
    System.out.println("Init Sonic...");
  }

  @Override
  protected void loadResources() {
    System.out.println("Load Sonic assets");
  }

  @Override
  protected void start() {
    System.out.println("Start Sonic");
  }
}

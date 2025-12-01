package com.vn.nghlong3004.template_method;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class MarioLoader extends GameLoader {
  @Override
  protected void init() {
    System.out.println("Init Mario...");
  }

  @Override
  protected void loadResources() {
    System.out.println("Load Mario assets");
  }

  @Override
  protected void start() {
    System.out.println("Start Mario");
  }
}

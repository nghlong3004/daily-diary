package com.vn.nghlong3004.template_method;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public abstract class GameLoader {

  public final void load() {
    init();
    loadResources();
    start();
  }

  protected abstract void init();
  protected abstract void loadResources();
  protected abstract void start();
}

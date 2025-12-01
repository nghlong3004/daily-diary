package com.vn.nghlong3004.template_method;

/**
 * Project: behavioral-design-patterns
 *
 * @author nghlong3004
 * @since 12/1/2025
 */
public class Main {
  public static void main(String[] args){
    GameLoader loader = new MarioLoader();
    loader.load();

    loader = new SonicLoader();
    loader.load();
  }
}

package com.vn.nghlong3004.flyweight;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class GrassTile implements Tile {

  private final String texture = "grass_texture.png";

  @Override
  public void draw(int x, int y) {
    System.out.println("Draw grass at (" + x + ", " + y + ")");
  }
}

package com.vn.nghlong3004.flyweight;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class WaterTile implements Tile {

  private final String texture = "water_texture.png";

  @Override
  public void draw(int x, int y) {
    System.out.println("Draw water at (" + x + ", " + y + ")");
  }
}


package com.vn.nghlong3004.flyweight;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
public class Main {
  public static void main(String[] args) {
    Tile t1 = TileFactory.getTile("grass");
    Tile t2 = TileFactory.getTile("grass");
    Tile t3 = TileFactory.getTile("water");

    t1.draw(0, 0);
    t2.draw(0, 1);
    t3.draw(1, 0);

    System.out.println("Same instance? " + (t1 == t2)); // true!
  }
}

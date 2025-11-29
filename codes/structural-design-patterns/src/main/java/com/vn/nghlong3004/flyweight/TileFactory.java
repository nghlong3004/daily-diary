package com.vn.nghlong3004.flyweight;

/**
 * Project: structural-design-patterns
 *
 * @author nghlong3004
 * @since 11/30/2025
 */
import java.util.HashMap;
import java.util.Map;

public class TileFactory {

  private static final Map<String, Tile> cache = new HashMap<>();

  public static Tile getTile(String type) {
    if (!cache.containsKey(type)) {
      switch (type) {
        case "grass" -> cache.put(type, new GrassTile());
        case "water" -> cache.put(type, new WaterTile());
        case "mountain" -> cache.put(type, new MountainTile());
      }
    }
    return cache.get(type);
  }
}

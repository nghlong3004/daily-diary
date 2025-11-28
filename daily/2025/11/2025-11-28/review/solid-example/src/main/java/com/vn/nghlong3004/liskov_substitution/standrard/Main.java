package com.vn.nghlong3004.liskov_substitution.standrard;

import java.util.List;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args){
    Shape rectangle = new Rectangle(10, 5);
    Shape square = new Square(5);
    System.out.println(totalArea(List.of(rectangle, square)));
  }

  public static int totalArea(List<Shape> shapes) {
    return shapes.stream()
            .mapToInt(Shape::area)
            .sum();
  }
}

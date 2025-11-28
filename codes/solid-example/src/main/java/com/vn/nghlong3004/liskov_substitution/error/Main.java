package com.vn.nghlong3004.liskov_substitution.error;

/**
 * Project: solid-example
 *
 * @author nghlong3004
 * @since 11/28/2025
 */
public class Main {
  public static void main(String[] args){
    Rectangle rectangle = new Rectangle();
    resize(rectangle);
    System.out.println(rectangle.area());
    rectangle = new Square();
    resize(rectangle);
    // Excepted: 50
    // but Actuator: 100 -> false
    System.out.println(rectangle.area());
  }

  public static void resize(Rectangle rectangle) {
    rectangle.setWidth(5);
    rectangle.setHeight(10);
    System.out.println("Area: " + rectangle.area());
  }
}

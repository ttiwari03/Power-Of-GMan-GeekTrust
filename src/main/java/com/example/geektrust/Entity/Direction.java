package com.example.geektrust.Entity;

public enum Direction {
  NORTH("N"),
  SOUTH("S"),
  EAST("E"),
  WEST("W");
  
  final String direction;
  
  Direction(String direction) {
    this.direction = direction;
  }
  
  public String getAcronym() {
    return direction;
  }
}

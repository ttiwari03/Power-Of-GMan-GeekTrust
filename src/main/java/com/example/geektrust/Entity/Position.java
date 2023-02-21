package com.example.geektrust.Entity;

import java.util.Objects;

public class Position {
  private Integer xCoordinate;
  private Integer yCoordinate;
  
  public Position(Integer xCoordinate, Integer yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }
  
  public Integer getXCoordinate() {
    return xCoordinate;
  }
  
  public Integer getYCoordinate() {
    return yCoordinate;
  }
  
  @Override
  public String toString() {
    return "Position{" +
        "xCoordinate=" + xCoordinate +
        ", yCoordinate=" + yCoordinate +
        '}';
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    
    Position position = (Position) obj;
    
    if (!Objects.equals(xCoordinate, position.xCoordinate)) return false;
    return Objects.equals(yCoordinate, position.yCoordinate);
  }
  
  @Override
  public int hashCode() {
    int result = xCoordinate != null ? xCoordinate.hashCode() : 0;
    result = 31 * result + (yCoordinate != null ? yCoordinate.hashCode() : 0);
    return result;
  }
}

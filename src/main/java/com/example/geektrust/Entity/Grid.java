package com.example.geektrust.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grid {
  private final Integer GRID_HEIGHT = 6;
  private final Integer GRID_WIDTH = 6;
  
  private final List<Position> gridPositions;
  
  public Grid() {
    gridPositions = new ArrayList<>();
    setGridPositions();
  }
  
  private void setGridPositions() {
    for (int xPos = 0; xPos <= GRID_WIDTH; xPos++) {
      for (int yPos = 0; yPos <= GRID_HEIGHT; yPos++) {
        Position position = new Position(xPos, yPos);
        gridPositions.add(position);
      }
    }
  }
  
  public Boolean isPositionValid(Position position) {
    for (Position pos : gridPositions) {
      if (Objects.equals(pos.getYCoordinate(), position.getYCoordinate()) && Objects.equals(pos.getXCoordinate(), position.getXCoordinate())) {
        return true;
      }
    }
    return false;
  }
}

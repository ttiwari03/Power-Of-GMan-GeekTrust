package com.example.geektrust.Service.Impl;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Grid;
import com.example.geektrust.Entity.Position;
import com.example.geektrust.Exception.InvalidPositionException;
import com.example.geektrust.Exception.NotEnoughPowerException;
import com.example.geektrust.Service.GManService;
import com.example.geektrust.Service.MovementService;

public class GManServiceImpl implements GManService {
  private final GMan gMan;
  private final Grid grid;
  
  public GManServiceImpl(GMan gMan, Grid grid) {
    this.gMan = gMan;
    this.grid = grid;
  }
  
  @Override
  public void setPosition(Position position, String direction) {
    if (grid.isPositionValid(position)) {
      gMan.setPosition(position);
      setDirection(direction);
    } else {
      System.out.println("Given position is not on grid.");
    }
  }
  
  private void setDirection(String direction) {
    for (Direction dir : Direction.values()) {
      if (dir.getAcronym().equals(direction)) {
        gMan.setDirection(dir);
        break;
      }
    }
  }
  
  @Override
  public void move(Position destination) throws NotEnoughPowerException {
    if (!grid.isPositionValid(destination)) {
      System.out.println("Given destination position is not on grid.");
      return;
    }
    Integer currentXCoordinate = gMan.getPosition().getXCoordinate();
    Integer currentYCoordinate = gMan.getPosition().getYCoordinate();
    Integer destinationXCoordinate = destination.getXCoordinate();
    Integer destinationYCoordinate = destination.getYCoordinate();
  
    MovementService movementService;
    if (currentXCoordinate <= destinationXCoordinate && currentYCoordinate <= destinationYCoordinate) {
      movementService = new MoveUpAndRight(gMan);
    } else if (currentXCoordinate <= destinationXCoordinate) {
      movementService = new MoveDownAndRight(gMan);
    } else if (currentYCoordinate <= destinationYCoordinate) {
      movementService = new MoveUpAndLeft(gMan);
    } else {
      movementService = new MoveDownAndLeft(gMan);
    }
    movementService.move(destination);
  }
  
  @Override
  public Integer remainingPower() {
    return gMan.getPower();
  }
}

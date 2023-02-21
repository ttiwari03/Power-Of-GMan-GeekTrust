package com.example.geektrust.Service.Impl;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Position;
import com.example.geektrust.Exception.NotEnoughPowerException;
import com.example.geektrust.Service.MovementService;

public class MoveDownAndLeft extends MovementService {
  private final GMan gMan;
  
  public MoveDownAndLeft(GMan gMan) {
    super(gMan);
    this.gMan = gMan;
  }
  @Override
  public void move(Position destination) throws NotEnoughPowerException {
    Direction currentDirection = gMan.getDirection();
    if (currentDirection.equals(Direction.SOUTH)) {
      super.moveOnYAxis(destination);
      super.turn(false);
      super.moveOnXAxis(destination);
    } else if (currentDirection.equals(Direction.WEST)) {
      super.moveOnXAxis(destination);
      super.turn(true);
      super.moveOnYAxis(destination);
    } else if (currentDirection.equals(Direction.NORTH)) {
      super.turn(true);
      super.moveOnXAxis(destination);
      super.turn(true);
      super.moveOnYAxis(destination);
    } else {
      super.turn(false);
      super.moveOnYAxis(destination);
      super.turn(false);
      super.moveOnXAxis(destination);
    }
  }
}

package com.example.geektrust.Service;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Position;
import com.example.geektrust.Exception.NotEnoughPowerException;

import java.util.ArrayList;

public abstract class MovementService {
  private final GMan gMan;
  private final ArrayList<Direction> clockwiseDirections;
  
  public MovementService(GMan gMan) {
    this.gMan = gMan;
    clockwiseDirections = new ArrayList<>();
    clockwiseDirections.add(Direction.NORTH);
    clockwiseDirections.add(Direction.EAST);
    clockwiseDirections.add(Direction.SOUTH);
    clockwiseDirections.add(Direction.WEST);
  }
  
  public abstract void move(Position destination) throws NotEnoughPowerException;
  
  protected void turn(Boolean toLeft) throws NotEnoughPowerException {
    int offset = 1;
    if (toLeft) {
      offset = -1;
    }
    if (gMan.getPower() >= gMan.getONE_TURN_POWER_REQUIREMENT()) {
      gMan.setPower(gMan.getPower() - gMan.getONE_TURN_POWER_REQUIREMENT());
      Direction currentDirection = gMan.getDirection();
      int currentDirectionPosition = clockwiseDirections.indexOf(currentDirection);
      int nextDirectionPosition = Math.floorMod(currentDirectionPosition + offset, clockwiseDirections.size());
      gMan.setDirection(clockwiseDirections.get(nextDirectionPosition));
    } else {
      throw new NotEnoughPowerException("GMan doesn't have sufficient power to turn in given direction.");
    }
  }
  
  protected void moveOnYAxis(Position destination) throws NotEnoughPowerException {
    Integer currentYCoordinate = gMan.getPosition().getYCoordinate();
    Integer destinationYCoordinate = destination.getYCoordinate();
    Integer requiredPower = Math.abs(currentYCoordinate - destinationYCoordinate) * gMan.getONE_MOVE_POWER_REQUIREMENT();
    Integer currentPower = gMan.getPower();
    if (requiredPower < currentPower) {
      Position newPosition = new Position(gMan.getPosition().getXCoordinate(), destinationYCoordinate);
      gMan.setPosition(newPosition);
      gMan.setPower(currentPower - requiredPower);
    } else {
      throw new NotEnoughPowerException("GMan's current power is not sufficient to move at given destination");
    }
  }
  
  protected void moveOnXAxis(Position destination) throws NotEnoughPowerException {
    Integer currentXCoordinate = gMan.getPosition().getXCoordinate();
    Integer destinationXCoordinate = destination.getXCoordinate();
    Integer requiredPower = Math.abs(currentXCoordinate - destinationXCoordinate) * gMan.getONE_MOVE_POWER_REQUIREMENT();
    Integer currentPower = gMan.getPower();
    if (requiredPower < currentPower) {
      Position newPosition = new Position(destinationXCoordinate, gMan.getPosition().getYCoordinate());
      gMan.setPosition(newPosition);
      gMan.setPower(currentPower - requiredPower);
    } else {
      throw new NotEnoughPowerException("GMan's current power is not sufficient to move at given destination");
    }
  }
}

package com.example.geektrust.Entity;

public class GMan {
  private final Integer ONE_TURN_POWER_REQUIREMENT = 5;
  private final Integer ONE_MOVE_POWER_REQUIREMENT = 10;
  
  private final Integer INITIAL_POWER = 200;
  private Integer power;
  private Position position;
  private Direction direction;
  
  public GMan() {
    this.power = INITIAL_POWER;
  }
  
  public Integer getONE_TURN_POWER_REQUIREMENT() {
    return ONE_TURN_POWER_REQUIREMENT;
  }
  
  public Integer getONE_MOVE_POWER_REQUIREMENT() {
    return ONE_MOVE_POWER_REQUIREMENT;
  }
  
  public Integer getINITIAL_POWER() {
    return INITIAL_POWER;
  }
  
  public Integer getPower() {
    return power;
  }
  
  public void setPower(Integer power) {
    this.power = power;
  }
  
  public Position getPosition() {
    return position;
  }
  
  public void setPosition(Position position) {
    this.position = position;
  }
  
  public Direction getDirection() {
    return direction;
  }
  
  public void setDirection(Direction direction) {
    this.direction = direction;
  }
  
  @Override
  public String toString() {
    return "GMan{" +
        "power=" + power +
        ", position=" + position +
        ", direction=" + direction +
        '}';
  }
}

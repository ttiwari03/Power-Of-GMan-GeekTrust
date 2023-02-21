package com.example.geektrust.ServiceTest;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Grid;
import com.example.geektrust.Entity.Position;
import com.example.geektrust.Service.GManService;
import com.example.geektrust.Service.Impl.GManServiceImpl;
import junit.framework.Assert;
import org.junit.jupiter.api.*;

@DisplayName("GManServiceTest")
public class GManServiceTest {
  private GMan gMan;
  
  private GManService gManService;
  
  @BeforeEach
  void setup() {
    gMan = new GMan();
    Grid grid = new Grid();
    gManService = new GManServiceImpl(gMan, grid);
  }
  
  @Test
  @DisplayName("GManService set position test")
  public void setPosition_ShouldSetGManPositionAsTwoOneAndDirectionAsNorth() {
    Position expectedPosition = new Position(2, 1);
    Direction expectedDirection = Direction.NORTH;
    
    Position position = new Position(2, 1);
    String directionAcronym = "N";
    
    gManService.setPosition(position, directionAcronym);
  
    Position actualPosition = gMan.getPosition();
    Direction actualDirection = gMan.getDirection();
    
    Assert.assertEquals(expectedPosition, actualPosition);
    Assert.assertEquals(expectedDirection, actualDirection);
  }
  
  @Test
  @DisplayName("GMan service move position test")
  public void move_ShouldMoveGManToPositionFiveFive() {
    gMan.setPosition(new Position(2, 1));
    gMan.setDirection(Direction.NORTH);
    Position expectedPosition = new Position(5, 5);
    
    gManService.move(new Position(5, 5));
    Position actualPosition = gMan.getPosition();
    
    Assert.assertEquals(expectedPosition, actualPosition);
  }
  
  @Test
  @DisplayName("GMan service move position with minimum power test")
  public void move_ShouldMoveGManToPositionFiveSixWithMinimumPowerSpent() {
    gMan.setPosition(new Position(1, 2));
    gMan.setDirection(Direction.EAST);
    Position expectedPosition = new Position(6, 6);
    Integer expectedPowerAfterMove = 105;
    
    gManService.move(expectedPosition);
    Integer actualPower = gMan.getPower();
    
    Assert.assertEquals(expectedPowerAfterMove, actualPower);
    
  }
  
  @Test
  @DisplayName("GMan service remaining power test")
  public void getPower_ShouldReturnOneHundred() {
    // arithmetic to change initial power
    gMan.setPower(gMan.getPower() - 100);
    Integer expectedPower = 100;
    
    Integer actualPower = gManService.remainingPower();
    
    Assert.assertEquals(expectedPower, actualPower);
  }
  
  @AfterEach
  void tearDown() {
    gMan = null;
    gManService = null;
  }
}

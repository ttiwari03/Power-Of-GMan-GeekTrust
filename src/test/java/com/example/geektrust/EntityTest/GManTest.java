package com.example.geektrust.EntityTest;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Position;
import junit.framework.Assert;
import org.junit.jupiter.api.*;

@DisplayName("GManTest")
public class GManTest {
  private static GMan gMan;
  
  @BeforeAll
  static void setUp() {
    gMan = new GMan();
    gMan.setPosition(new Position(2, 1));
    gMan.setDirection(Direction.NORTH);
  }
  
  @Test
  @DisplayName("GMan direction test")
  public void getDirection_ShouldReturnNORTH() {
    Direction expectedDirection = Direction.NORTH;
    
    Direction actualDirection = gMan.getDirection();
  
    Assert.assertEquals(expectedDirection, actualDirection);
  }
  
  @Test
  @DisplayName("GMan position test")
  public void getPosition_ShouldReturnTwoAndOneAsPosition() {
    Position expectedPosition = new Position(2, 1);
    
    Position actualPosition = gMan.getPosition();
    
    Assert.assertEquals(expectedPosition, actualPosition);
  }
  
  @Test
  @DisplayName("GMan's initial power test")
  public void getPower_ShouldReturnTwoHundred() {
    Integer expectedPower = 200;
    
    Integer actualPower = gMan.getPower();
    
    Assert.assertEquals(expectedPower, actualPower);
  }
  @AfterAll
  static void tearDown() {
    gMan = null;
  }
}

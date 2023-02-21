package com.example.geektrust.ServiceTest;

import com.example.geektrust.Entity.Direction;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Position;
import com.example.geektrust.Service.Impl.MoveDownAndLeft;
import com.example.geektrust.Service.Impl.MoveDownAndRight;
import com.example.geektrust.Service.Impl.MoveUpAndLeft;
import com.example.geektrust.Service.Impl.MoveUpAndRight;
import com.example.geektrust.Service.MovementService;
import org.junit.jupiter.api.*;

@DisplayName("MovementServiceTest")
public class MovementServiceTest {
  private GMan gMan;
  private MovementService movementService;
  
  @BeforeEach
  void setUp() {
    gMan = new GMan();
    gMan.setPosition(new Position(3, 3));
    gMan.setDirection(Direction.NORTH);
  }
  
  @Test
  @DisplayName("MoveUpAndLeftTest")
  public void move_ShouldMoveGManAtPositionOneFive() {
    Position expectedPosition = new Position(1, 5);
    
    movementService = new MoveUpAndLeft(gMan);
    movementService.move(new Position(1, 5));
    Assertions.assertEquals(gMan.getPosition(), expectedPosition);
  }
  
  @Test
  @DisplayName("MoveUpAndRightTest")
  public void move_ShouldMoveGManAtPositionFourFive() {
    Position expectedPosition = new Position(4, 5);
    
    movementService = new MoveUpAndRight(gMan);
    movementService.move(new Position(4, 5));
    Assertions.assertEquals(gMan.getPosition(), expectedPosition);
  }
  
  @Test
  @DisplayName("MoveDownAndLeftTest")
  public void move_ShouldMoveGManAtPositionOneAndOne() {
    Position expectedPosition = new Position(1, 1);
    
    movementService = new MoveDownAndLeft(gMan);
    movementService.move(new Position(1, 1));
    Assertions.assertEquals(gMan.getPosition(), expectedPosition);
  }
  
  @Test
  @DisplayName("MoveDownAndRightTest")
  public void move_ShouldMoveGManAtPositionFourOne() {
    Position expectedPosition = new Position(4, 1);
    
    movementService = new MoveDownAndRight(gMan);
    movementService.move(new Position(4, 1));
    Assertions.assertEquals(gMan.getPosition(), expectedPosition);
  }
}

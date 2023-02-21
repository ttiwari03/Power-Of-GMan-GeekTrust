package com.example.geektrust.Command;

import com.example.geektrust.Entity.Position;
import com.example.geektrust.Exception.NotEnoughPowerException;
import com.example.geektrust.Service.GManService;

public class DestinationCommand implements ICommand {
  private final GManService gManService;
  
  public DestinationCommand(GManService gManService) {
    this.gManService = gManService;
  }
  
  @Override
  public void execute(String[] input) {
    Integer xCoordinate = Integer.parseInt(input[1]);
    Integer yCoordinate = Integer.parseInt(input[2]);
    Position destination = new Position(xCoordinate, yCoordinate);
    try {
      gManService.move(destination);
    } catch (NotEnoughPowerException exception) {
      System.out.println(exception.getMessage());
    }
  }
}

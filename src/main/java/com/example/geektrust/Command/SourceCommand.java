package com.example.geektrust.Command;

import com.example.geektrust.Entity.Position;
import com.example.geektrust.Service.GManService;

public class SourceCommand implements ICommand {
  private final GManService gManService;
  
  public SourceCommand(GManService gManService) {
    this.gManService = gManService;
  }
  @Override
  public void execute(String[] input) {
    Integer xCoordinate = Integer.parseInt(input[1]);
    Integer yCoordinate = Integer.parseInt(input[2]);
    String direction = input[3];
    Position position = new Position(xCoordinate, yCoordinate);
    gManService.setPosition(position, direction);
  }
}

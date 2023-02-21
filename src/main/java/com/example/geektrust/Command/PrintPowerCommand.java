package com.example.geektrust.Command;

import com.example.geektrust.Service.GManService;

public class PrintPowerCommand implements ICommand {
  private final GManService gManService;
  
  public PrintPowerCommand(GManService gManService) {
    this.gManService = gManService;
  }
  @Override
  public void execute(String[] input) {
    System.out.println("POWER " + gManService.remainingPower());
  }
}

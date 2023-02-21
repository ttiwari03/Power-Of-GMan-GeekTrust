package com.example.geektrust.Config;

import com.example.geektrust.Command.*;
import com.example.geektrust.Entity.GMan;
import com.example.geektrust.Entity.Grid;
import com.example.geektrust.Service.GManService;
import com.example.geektrust.Service.Impl.GManServiceImpl;

public class AppConfig {
  private final GMan gMan = new GMan();
  private final Grid grid = new Grid();
  
  private final GManService gManService = new GManServiceImpl(gMan, grid);
  
  private final SourceCommand sourceCommand = new SourceCommand(gManService);
  private final DestinationCommand destinationCommand = new DestinationCommand(gManService);
  private final PrintPowerCommand printPowerCommand = new PrintPowerCommand(gManService);
  
  private final CommandInvoker commandInvoker = new CommandInvoker();
  
  public CommandInvoker getCommandInvoker() {
    commandInvoker.register(InputCommand.SOURCE.name(), sourceCommand);
    commandInvoker.register(InputCommand.DESTINATION.name(), destinationCommand);
    commandInvoker.register(InputCommand.PRINT_POWER.name(), printPowerCommand);
    return commandInvoker;
  }
}

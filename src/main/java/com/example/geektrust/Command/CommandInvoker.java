package com.example.geektrust.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
  private final Map<String, ICommand> commands;
  
  public CommandInvoker() {
    commands = new HashMap<>();
  }
  
  public void register(String commandName, ICommand command) {
    commands.put(commandName, command);
  }
  
  public ICommand retrieve(String commandName) {
    return commands.get(commandName);
  }
  
  public void execute(String[] input) {
    ICommand command = retrieve(input[0]);
    command.execute(input);
  }
}

package com.example.geektrust.Service;

import com.example.geektrust.Entity.Position;
import com.example.geektrust.Exception.InvalidPositionException;
import com.example.geektrust.Exception.NotEnoughPowerException;

public interface GManService {
  void setPosition(Position position, String direction);
  
  void move(Position destination) throws NotEnoughPowerException, InvalidPositionException;
  Integer remainingPower();
}
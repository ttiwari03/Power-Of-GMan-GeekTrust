package com.example.geektrust.Exception;

public class NotEnoughPowerException extends RuntimeException {
  public NotEnoughPowerException(String message) {
    super(message);
  }
  
  public NotEnoughPowerException() {
    super();
  }
}

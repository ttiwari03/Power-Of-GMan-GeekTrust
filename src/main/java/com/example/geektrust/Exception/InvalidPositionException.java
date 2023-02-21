package com.example.geektrust.Exception;

public class InvalidPositionException extends RuntimeException {
  public InvalidPositionException() {
    super();
  }
  
  public InvalidPositionException(String message) {
    super(message);
  }
}

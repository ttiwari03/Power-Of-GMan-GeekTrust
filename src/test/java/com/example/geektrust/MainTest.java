package com.example.geektrust;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("GManMainTest")
public class MainTest {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  
  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStream));
  }
  
  @Test
  @DisplayName("Integration Test #1")
  public void runIntegrationTest1() {
    String[] arguments = new String[]{"sample_input/input1.txt"};
   
    String expectedOutput = "POWER 155";
    
    Main.main(arguments);
    Assertions.assertEquals(expectedOutput, outputStream.toString().trim());
  }
  
  @Test
  @DisplayName("Integration Test #2")
  public void runIntegrationTest2() {
    String[] arguments = new String[]{"sample_input/input2.txt"};
    
    String expectedOutput = "POWER 90";
  
    Main.main(arguments);
    Assertions.assertEquals(expectedOutput, outputStream.toString().trim());
  }
  
  @Test
  @DisplayName("Integration Test #3")
  public void runIntegrationTest3() {
    String[] arguments = new String[]{"sample_input/input3.txt"};
    
    String expectedOutput = "POWER 110";
  
    Main.main(arguments);
    Assertions.assertEquals(expectedOutput, outputStream.toString().trim());
  }
  
  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
  }
}
package battleship;

import java.util.Scanner;

public class ConsoleStrategy implements Strategy {
  
  private final Scanner input;
  
  public ConsoleStrategy(Scanner sc) {
    input = sc;
  }

  @Override
  public Scanner behaviour() {
    return input;
  }
  
}

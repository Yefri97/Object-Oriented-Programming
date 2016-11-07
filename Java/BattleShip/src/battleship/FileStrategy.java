package battleship;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStrategy implements Strategy {
  
  private final Scanner input;
  
  public FileStrategy(File file) throws FileNotFoundException {
    input = new Scanner(file);
  }

  @Override
  public Scanner behaviour() {
    return input;
  }
  
}

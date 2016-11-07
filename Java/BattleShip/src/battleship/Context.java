package battleship;

import java.util.Scanner;

public class Context {
  Strategy c;

  public Context(Strategy c){
    this.c = c;
  }

  public void setStrategy(Strategy c) {
    this.c = c;
  }
  
  public Scanner getInput()
  {
    return c.behaviour();
  }
}

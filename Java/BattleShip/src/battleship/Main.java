package battleship;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * ENTRADAS
 * 3 2
 * 2 2
 * 1 2 1
 * 2 0 2
 * 
 * 4 3
 * 2 3 2
 * 3 0 2 2
 * 2 1 1 3
 * 
 * 6 4
 * 2 1 3 2
 * 3 0 2 2 1 0
 * 2 1 1 3 0 1
 * 
 * @author Yeferson Gaitan Gomez
 */
public class Main {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
      
      System.out.println("Que entrada desea utilizar?");
      System.out.println("1. Entrada por consola");
      System.out.println("2. Entrada por archivo");
      System.out.println("3. Entrada por pagina web");
      
      Scanner sc = new Scanner(System.in);
      String number = sc.nextLine();
      
      Strategy initial = new ConsoleStrategy(sc);
      Context context = new Context(initial);
      switch (number) {
        case "1":
          System.out.println("La entrada es por consola:");
          break;
        case "2":
          System.out.println("La entrada es por archivo:");
          context.setStrategy(new FileStrategy(new File(sc.nextLine())));
          break;
        case "3":
          System.out.println("La entrada es por URL:");
          context.setStrategy(new WebPageStrategy(new URL(sc.nextLine())));
          break;
        default:
          System.out.println("Valor no aceptado");
          return;
      }
      Scanner input = context.getInput();
      
      int sizeBoard = input.nextInt();
      
      int numShips = input.nextInt();
      
      int[] typeShip = new int[sizeBoard];
      for (int i = 0; i < numShips; i++) {
        int x = input.nextInt(); x--;
        typeShip[x]++;
      }
      
      int[] row = new int[sizeBoard], col = new int[sizeBoard];
      for (int i = 0; i < sizeBoard; i++) row[i] = input.nextInt();
      for (int i = 0; i < sizeBoard; i++) col[i] = input.nextInt();
      
      CSPBattleShip csp = new CSPBattleShip(sizeBoard, typeShip, row, col);
      
      int board[][] = new int[sizeBoard][sizeBoard];
      boolean isSolved = csp.solver(board);
      if (isSolved) {
        for (int i = 0; i < sizeBoard; i++) {
          for (int j = 0; j < sizeBoard; j++)
            System.out.print(board[i][j]);
          System.out.print("\n");
        }
      } else {
        System.out.println("El problema no tiene solución");
      }
      
    }
    
}

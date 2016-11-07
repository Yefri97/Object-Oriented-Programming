package battleship;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
      
      // Aqui el usuario toma la desición de como ingresar los datos
      System.out.println("Que entrada desea utilizar?");
      System.out.println("1. Entrada por consola");
      System.out.println("2. Entrada por archivo");
      System.out.println("3. Entrada por pagina web");
      
      Scanner sc = new Scanner(System.in);
      String number = sc.nextLine();
      
      // Patron de diseño comportamental: Strategy 
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
      
      // Tamaño del tablero
      int sizeBoard = input.nextInt();
      
      // Numero de barcos
      int numShips = input.nextInt();
      
      // Tamaño de los barcos
      int[] typeShip = new int[sizeBoard];
      for (int i = 0; i < numShips; i++) {
        int x = input.nextInt(); x--;
        typeShip[x]++;
      }
      
      // Suma de las filas y de las columnas
      int[] row = new int[sizeBoard], col = new int[sizeBoard];
      for (int i = 0; i < sizeBoard; i++) row[i] = input.nextInt();
      for (int i = 0; i < sizeBoard; i++) col[i] = input.nextInt();
      
      // Creo el Constraint Satisfaction Problem
      CSPBattleShip csp = new CSPBattleShip(sizeBoard, typeShip, row, col);
      
      // Hallamos una solución al CSP
      int board[][] = new int[sizeBoard][sizeBoard];
      boolean isSolved = csp.solver(board);
      if (isSolved) {
        for (int i = 0; i < sizeBoard; i++) {
          for (int j = 0; j < sizeBoard; j++)
            System.out.print((board[i][j] == 1)? "*" : ".");
          System.out.print("\n");
        }
      } else {
        System.out.println("El problema no tiene solución");
      }
      
    }
    
}

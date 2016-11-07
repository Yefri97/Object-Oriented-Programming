package battleship;

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
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      int sizeBoard = sc.nextInt();
      
      int numShips = sc.nextInt();
      
      int[] typeShip = new int[sizeBoard];
      for (int i = 0; i < numShips; i++) {
        int x = sc.nextInt(); x--;
        typeShip[x]++;
      }
      
      int[] row = new int[sizeBoard], col = new int[sizeBoard];
      for (int i = 0; i < sizeBoard; i++) row[i] = sc.nextInt();
      for (int i = 0; i < sizeBoard; i++) col[i] = sc.nextInt();
      
      CSPBattleShip csp = new CSPBattleShip(sizeBoard, typeShip, row, col);
      
      int board[][] = csp.solver();
      
      for (int i = 0; i < sizeBoard; i++) {
        for (int j = 0; j < sizeBoard; j++)
          System.out.print(board[i][j]);
        System.out.print("\n");
      }
      
    }
    
}

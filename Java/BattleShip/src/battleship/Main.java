package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Variable;
import java.util.Scanner;

/**
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
      
      int[] typeShip = new int[numShips];
      for (int i = 0; i < numShips; i++) typeShip[i] = sc.nextInt();
      
      int[] row, col;
      row = col = new int[sizeBoard];
      for (int i = 0; i < sizeBoard; i++) row[i] = sc.nextInt();
      for (int i = 0; i < sizeBoard; i++) col[i] = sc.nextInt();
      
      CSPBattleShip csp = new CSPBattleShip(sizeBoard, typeShip, row, col);
      
      Assignment result = csp.solver();
      
      int board[][] = new int[sizeBoard][sizeBoard];
      
      for (int i = 0; i < sizeBoard; i++) {
        for (int j = 0; j < sizeBoard; j++) {
          int idx = i * sizeBoard + j;
          Variable var = new Variable("X_"+idx);
          Integer value = (Integer)result.getAssignment(var);
          board[i][j] = value;
        }
      }
      
      for (int i = 0; i < sizeBoard; i++) {
        for (int j = 0; j < sizeBoard; j++)
          System.out.print(board[i][j]);
        System.out.print("\n");
      }
      
    }
    
}

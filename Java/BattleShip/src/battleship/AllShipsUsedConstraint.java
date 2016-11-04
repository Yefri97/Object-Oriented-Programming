package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author web
 */
public class AllShipsUsedConstraint implements Constraint {
  
  private final int sizeBoard;
  private final List<Variable> scope;
  private final List<Integer> typeShips = new ArrayList();
  
  public AllShipsUsedConstraint(List<Variable> s, int[] arr) {
    this.sizeBoard = arr.length;
    this.scope = s;
    for (int i = 0; i < this.sizeBoard; i++) this.typeShips.add(arr[i]);
  }

  @Override
  public List<Variable> getScope() {
    return scope;
  }

  @Override
  public boolean isSatisfiedWith(Assignment assignment) {
    System.out.println(typeShips.get(0));
    int[][] board = new int[sizeBoard][sizeBoard];
    for (int i = 0; i < sizeBoard; i++) for (int j = 0; j < sizeBoard; j++) {
      int idx = i * sizeBoard + j;
      Integer value = (Integer)assignment.getAssignment(scope.get(idx));
      if (value == null) return true;
      board[i][j] = value;
    }
    
    int visit[][] = new int[sizeBoard][sizeBoard];
    for (int i = 0; i < sizeBoard; i++) for (int j = 0; j < sizeBoard; j++) {
      if (board[i][j] == 0 || visit[i][j] == 1) continue;
      
      int mi = 0, mj = 0, ok = 0;
      if (j + 1 < sizeBoard && board[i][j + 1] == 1) { mi = 0; mj = 1; ok++; }
      if (i + 1 < sizeBoard && board[i + 1][j] == 1) { mi = 1; mj = 0; ok++; }
      
      visit[i][j] = 1;
      if (ok == 0) continue;
      if (ok == 2) return false;
      
      int cont = 1;
      for (int k = i + mi, l = j + mj; k < sizeBoard && l < sizeBoard; k += mi, l += mj) {
        if (board[k][l] == 0) break;
        visit[k][l] = 1;
        cont++;
      }
      int num = typeShips.get(cont - 1);
      if (num == 0) return false;
      typeShips.set(cont - 1, num - 1);
    }
    
    return true;
    
  }
  
}

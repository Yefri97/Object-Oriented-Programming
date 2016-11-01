package battleship;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import java.util.List;

/**
 *
 * @author Yeferson Gaitan Gomez
 */
public class CSPBattleShip {
    
  private List<Variable> cells;
  private final Domain ships;
  private final Constraint sumRows;
  private final Constraint sumCols;
  
  private final CSP csp;
  
  public CSPBattleShip(int sizeBoard, int[] typeShips, int[] row, int[] col) {
    
    // Genero todas las variables del tablero -> Xi
    for (int i = 0; i < sizeBoard * sizeBoard; i++) {
      Variable Xi = new Variable("X_"+i);
      cells.add(Xi);
    }
    
    csp = new CSP(cells);
    
    // Genero el dominio para las variables
    // dominio = {0, 1, 2, 3, ... n} -> dominio[i] = id del barco
    int numShips = typeShips.length;
    List<Integer> domain = null;
    for (int i = 0; i <= numShips; i++) domain.add(i);
    ships = new Domain(domain);
    
    // Configuro el dominio para todas la variables del tablero
    for (int i = 0; i < sizeBoard * sizeBoard; i++) {
      Variable Xi = new Variable("X_"+i);
      csp.setDomain(Xi, ships);
    }
    
  }
    
}

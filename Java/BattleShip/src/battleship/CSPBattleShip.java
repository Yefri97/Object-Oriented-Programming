package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

public class CSPBattleShip {
   
  private final int sizeBoard;
  private final List<Variable> cells = new ArrayList();
  private final Domain waterOrShip;
  private final Constraint sumRows;
  private final Constraint sumCols;
  private final Constraint allUsed;
  
  private final CSP csp;
  
  public CSPBattleShip(int sizeBoard, int[] typeShips, int[] row, int[] col) {
    
    this.sizeBoard = sizeBoard;
    
    // Genero todas las variables del tablero -> Xi
    for (int i = 0; i < sizeBoard * sizeBoard; i++) {
      Variable Xi = new Variable("X_"+i);
      cells.add(Xi);
    }
    
    csp = new CSP(cells);
    
    // Genero el dominio para las variables
    // dominio = {0, 1} -> 0: Agua, 1: Barco
    waterOrShip = new Domain(new Object[] {0, 1});
    
    // Configuro el dominio para todas la variables del tablero
    for (int i = 0; i < sizeBoard * sizeBoard; i++) {
      csp.setDomain(cells.get(i), waterOrShip);
    }
    
    // Patron de diseño creacional: Factory Method
    Creator factory = new ConstraintCreator();
    
    sumRows = factory.factoryMethod(cells, row, 1); // TotalSumRowConstraint
    sumCols = factory.factoryMethod(cells, col, 2); // TotalSumColConstraint
    allUsed = factory.factoryMethod(cells, typeShips, 3); // AllShipsUsedConstraint
    
    // Agrego las restricciones al problema
    csp.addConstraint(sumRows);
    csp.addConstraint(sumCols);
    csp.addConstraint(allUsed);
    
  }
  
  public boolean solver(int[][] board) {
    // Solución por Backtracking
    Assignment results = new BacktrackingStrategy().solve(csp);
    
    // Si existe una solución la retorna
    for (int i = 0; i < sizeBoard; i++) {
      for (int j = 0; j < sizeBoard; j++) {
        int idx = i * sizeBoard + j;
        Integer value = (Integer)results.getAssignment(cells.get(idx));
        if (value == null) return false;
        board[i][j] = value;
      }
    }
    
    return true;
    
  }
    
}

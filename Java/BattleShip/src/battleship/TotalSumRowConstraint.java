package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que usa la interface Constraint para restringir la 
 * asignación correcta a la variables
 * 
 * Constraint: Verificar si la suma de las variables asignadas 
 * por cada fila cumplen con la especificada en el arreglo.
 *
 * @author Yeferson Gaitan Gomez
 */
public class TotalSumRowConstraint implements Constraint {
  
  private final int sizeBoard;
  private final List<Variable> scope;
  private final List<Integer> totalSum;
  
  public TotalSumRowConstraint(List<Variable> s, int[] row) {
    this.scope = s;
    this.sizeBoard = row.length;
    totalSum = new ArrayList<Integer>(sizeBoard);
    for (int i = 0; i < totalSum.size(); i++) totalSum.add(row[i]);
  }

  @Override
  public List<Variable> getScope() {
    return scope;
  }
  
  @Override
  public boolean isSatisfiedWith(Assignment assignment) {
    for (int i = 0; i < sizeBoard; i++) {
      int cont = 0;
      for (int j = 0; j < sizeBoard; j++) {
        int idx = i * sizeBoard + j;
        Integer value = (Integer)assignment.getAssignment(scope.get(idx));
        if (value != 0) cont++;
      }
      if (cont != totalSum.get(i)) return false;
    }
    return true;
  }
}

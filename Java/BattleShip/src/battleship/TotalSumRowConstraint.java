package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

public class TotalSumRowConstraint implements Constraint {
  
  private final int sizeBoard;
  private final List<Variable> scope;
  private final List<Integer> totalSum = new ArrayList();
  
  public TotalSumRowConstraint(List<Variable> s, int[] row) {
    this.sizeBoard = row.length;
    this.scope = s;
    for (int i = 0; i < this.sizeBoard; i++) this.totalSum.add(row[i]);
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
        if (value == null) return true;
        cont += value;
      }
      if (cont != totalSum.get(i)) return false;
    }
    return true;
  }
}

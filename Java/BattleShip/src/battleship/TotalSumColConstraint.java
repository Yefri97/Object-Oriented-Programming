package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.ArrayList;
import java.util.List;

public class TotalSumColConstraint implements Constraint {
  
  private final int sizeBoard;
  private final List<Variable> scope;
  private final List<Integer> totalSum = new ArrayList();
  
  public TotalSumColConstraint(List<Variable> s, int[] col) {
    this.sizeBoard = col.length;
    this.scope = s;
    for (int i = 0; i < this.sizeBoard; i++) this.totalSum.add(col[i]);
  }

  @Override
  public List<Variable> getScope() {
    return scope;
  }
  
  @Override
  public boolean isSatisfiedWith(Assignment assignment) {
    for (int j = 0; j < sizeBoard; j++) {
      int cont = 0;
      for (int i = 0; i < sizeBoard; i++) {
        int idx = i * sizeBoard + j;
        Integer value = (Integer)assignment.getAssignment(scope.get(idx));
        if (value == null) return true;
        cont += value;
      }
      if (cont != totalSum.get(j)) return false;
    }
    return true;
  }
}

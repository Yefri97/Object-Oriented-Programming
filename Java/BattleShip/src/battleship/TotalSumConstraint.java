package battleship;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.List;

/**
 *
 * @author Yeferson Gaitan Gomez
 */
public class TotalSumConstraint implements Constraint {
  
  private final List<Variable> scope;
  private final List<Integer> totalSum;
  
  public TotalSumConstraint(List<Variable> s, List<Integer> ts) {
    this.scope = s;
    this.totalSum = ts;
  }

  @Override
  public List<Variable> getScope() {
    return scope;
  }

  @Override
  public boolean isSatisfiedWith(Assignment assignment) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int idx = formulota(i, j);
      }
    }
  }
}

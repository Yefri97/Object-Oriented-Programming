package battleship;

import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.List;

public class ConstraintCreator extends Creator {

  @Override
  public Constraint factoryMethod(List<Variable> s, int[] arr, int id) {
    switch (id) {
      case 1:
        return new TotalSumRowConstraint(s, arr);
      case 2:
        return new TotalSumColConstraint(s, arr);
      default:
        return new AllShipsUsedConstraint(s, arr);
    }
  }
  
}

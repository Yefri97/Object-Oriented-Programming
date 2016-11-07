package battleship;

import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;
import java.util.List;

abstract class Creator {
  public abstract Constraint factoryMethod(List<Variable> s, int[] arr, int id);
}

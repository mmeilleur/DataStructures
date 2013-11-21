// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import java.util.Comparator;

public class NaturalIntegerPairComparator implements Comparator<Pair<Integer>> {
  
  public int compare (Pair one, Pair two) {
    int result = 0;
    if (one.first().compareTo(two.first()) < 0)
      result = -1;
    else if (one.first().compareTo(two.first()) == 0) {
      if (one.second().compareTo(two.second()) > -1)
        result = 1;
    }
    return result;
  }
  
}
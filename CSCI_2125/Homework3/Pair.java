// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

/**
 * A class to model a pair of elements.
 */
public class Pair<Element extends Comparable<? super Element>> {
  
  private Element one;
  private Element two;
  
  public Pair (Element elementOne, Element elementTwo) {
    this.one = elementOne;
    this.two = elementTwo;
  }
  
  public Element first () {
    return this.one;
  }
  
  public Element second () {
    return this.two;
  }
  
}
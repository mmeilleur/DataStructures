// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/30/2011
// Assignment: Homework 2 Part II

package CSCI_2125.Homework2ii;

/**
 * An object that models an element in a bag and keeps track of the number.
 */
public class BagElement<Element> {
  
  private Element element;
  private int count;
  
  public BagElement (Element element, int initialQuantity) {
    this.element = element;
    this.count = initialQuantity;
  }
  
  public void changeCount (int newQuantity) {
    this.count = newQuantity;
  }
  
  public void increaseCount () {
    this.count = this.count + 1;
  }
  
  public void decreaseCount () {
    this.count = this.count - 1;
  }
  
  public int count () {
    return this.count;
  }
  
  public int element () {
    return this.element();
  }
  
}
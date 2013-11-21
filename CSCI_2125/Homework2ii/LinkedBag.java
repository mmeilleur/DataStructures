// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/30/2011
// Assignment: Homework 2 Part II

package CSCI_2125.Homework2ii;

import nhUtilities.containers2.*;

/**
 * This class is used to model a Bag that can hold any number of Elements.
 */
public class LinkedBag <Element> extends AbstractBag <Element> {
  
  private int size;
  private LinkedList <Element> elements;
  
  /**
   * Creates a new bag that uses a LinkedList to store elements
   */
  public LinkedBag () {
    size = 0;
    elements = new LinkedList <Element> ();
  }
  
  /**
   * Add the given element to this Bag in the specified quantity.
   * 
   * @require     element != null, quantity >= 0
   * @ensure      this.isMember(element) == true 
   *              && this.size() == old.size() + quantity
   *              && this.numberOf (element) == this.numberOf (element) + quantity
   * 
   */
  public void add (Element element, int quantity) {
    int i = 0;
    
    //Adds the requested quantity of elements to the Bag
    while ( i < quantity) {
      elements.add (element);
      i = i + 1;
      this.size = this.size + 1;
    }    
  }
  
  
  /**
   * Remove the given element in the specified quantity from this Bag if
   * this.isMember(element) == true.
   * 
   * @require     element != null, quantity >= 0
   * @ensure      if old.isMember (element) && old.numberOf (element) > quantity, 
   *              then this.isMember (element) == true 
   *              && this.size() == old.size() - quantity 
   *              && this.numberOf (element) == old.numberOf (element) - quantity
   *              otherwise,
   *              if old.isMember (element) && old.numberOf (element) <= quantity, 
   *              then this.isMember (element) == false
   *              && this.size () == old.size () - old.numberOf (element)
   */
  public void remove (Element element, int quantity) {
    if (this.numberOf(element) >= quantity) {
      int i = 0;
      while (i < quantity) {
        elements.remove(element);
        i = i + 1;
      }
      size = size - quantity;
    }
    else {
      removeAll(element);
      size = size - this.numberOf(element);
    }
  }  
  
  
  /**
   * Remove all elements from this Bag.
   * 
   * @ensure      this.size() == 0
   */
  public void emptyBag () {
    elements = new LinkedList<Element> ();
    size = 0;
  }   
  
  
  /**
   * Returns the total number of elements in the Bag.
   * 
   * @ensure      Returns the number of elements
   *              in the Bag which will be >= 0.
   *              size() = The sum of this.numberOf(e) for each element
   *                       in this Bag.
   */
  public int size () {
    return this.size;
  }
  
  
  /**
   * Returns an iterator that traverses the Bag.
   * 
   * @ensure      Will return an iterator for
   *              this Bag.
   */
  public Iterator<Element> iterator () {
    return elements.iterator();
  }
  
  
  /**
   * Returns an empty Bag.
   * 
   * @ensure      result.size() == 0
   */
  public LinkedBag<Element> newBag () {
    return new LinkedBag<Element>();
  }
  
}
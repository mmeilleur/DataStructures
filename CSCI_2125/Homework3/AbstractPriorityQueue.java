// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import java.util.Comparator;

/**
 * An abstract class that models a Priority Queue.  Highest priority 
 * elements are dispensed first.
 * 
 * The following methods must be implemented in any concrete class:
 * 
 * public Element highest ();
 * public Comparator<Element> priority ();
 * public int size ();
 * public void enqueue (Element element);
 * public void serve ();
 * public String toString ();
 * 
 */
public abstract class AbstractPriorityQueue<Element extends 
  Comparable<? super Element>> implements PriorityQueue<Element>{
  
  /**
   * Returns true is there are no elements in this PriorityQueue.
   * 
   * @ensure     There are no elements in this PriorityQueue
   */
  public boolean isEmpty() {
    return this.size() == 0;
  }
  
  /**
   * Returns the element currently at the top of this PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      No other element in this PriorityQueue has a higher
   *              order than the returned element.
   */
  public abstract Element highest();
  
  /**
   * Returns a Comparator that is used to determine the priority
   * ordering of this PriorityQueue.
   * 
   * @ensure     All elements in this PriorityQueue are ordered using
   *             priority.
   */
  public abstract Comparator<Element> priority ();
  
  /**
   * Returns the number of elements currently in this PriorityQueue
   * 
   * @ensure      result >= 0
   */
  public abstract int size ();
  
  /**
   * Adds an element to the PriorityQueue.
   * 
   * @require     element != null
   * 
   * @ensure      Elements are added in order by this.priority()
   *              !this.isEmpty()
   *              this.size() == this.size() + 1
   */
  public abstract void enqueue (Element element);
  
  /**
   * Removes the element with the highest priority from this
   * PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      this.size() == this.size() - 1
   */
  public abstract void serve ();
  
  /**
   * Returns a string representation of this PriorityQueue.
   * 
   * @ensure      Format will be:
   *              [last priority element, ..., first priority element]
   */
  public abstract String toString ();
    
}
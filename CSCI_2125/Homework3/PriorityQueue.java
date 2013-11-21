// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import java.util.Comparator;

/**
 * Interface that models a Priority Queue.  Highest priority elements
 * are dispensed first.
 */
public interface PriorityQueue<Element extends Comparable<? super Element>> {
  
  /**
   * Returns true is there are no elements in this PriorityQueue.
   * 
   * @ensure     There are no elements in this PriorityQueue
   */
  public boolean isEmpty();
  
  /**
   * Returns the element currently at the top of this PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      No other element in this PriorityQueue has a higher
   *              order than the returned element.
   */
  public Element highest();
  
  /**
   * Returns a Comparator that is used to determine the priority
   * ordering of this PriorityQueue.
   * 
   * @ensure     All elements in this PriorityQueue are ordered using
   *             priority.
   */
  public Comparator<Element> priority ();
  
  /**
   * Returns the number of elements currently in this PriorityQueue
   * 
   * @ensure      result >= 0
   */
  public int size ();
  
  /**
   * Adds an element to the PriorityQueue.
   * 
   * @require     element != null
   * 
   * @ensure      Elements are added in order by this.priority()
   *              !this.isEmpty()
   *              this.size() == this.size() + 1
   */
  public void enqueue (Element element);
  
  /**
   * Removes the element with the highest priority from this
   * PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      this.size() == this.size() - 1
   */
  public void serve ();
  
  /**
   * Returns a string representation of this PriorityQueue.
   * 
   * @ensure      Format will be:
   *              [last priority element, ..., first priority element]
   */
  public String toString ();
  
  
}
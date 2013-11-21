// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import nhUtilities.containers2.*;
import java.util.Comparator;

/**
 * A class that models a Priority Queue using a LinkedList<Element>.  
 * Highest priority elements are dispensed first.
 * 
 * The following methods must be implemented in any concrete class:
 * 
 * public void enqueue (Element element);
 * 
 */
public class LinkedPriorityQueue<Element extends Comparable<? super Element>> 
  extends AbstractPriorityQueue<Element> {
  
  private Comparator<Element> priority;
  private List<Element> orderedElements; 
 
  /**
   * Constructs a new LinkedPriorityQueue with the supplied Comparator<Element>
   * order.
   * 
   * @require     
   * 
   * @ensure      
   */
  public LinkedPriorityQueue (Comparator<Element> order) {
    orderedElements = new LinkedList<Element> ();
    priority = order;
  }
  
  /**
   * Returns the element currently at the top of this PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      No other element in this PriorityQueue has a higher
   *              order than the returned element.
   */
  public Element highest() {
    return orderedElements.get(0);
  }
  
  /**
   * Returns a Comparator that is used to determine the priority
   * ordering of this PriorityQueue.
   * 
   * @ensure     All elements in this PriorityQueue are ordered using
   *             priority.
   */
  public Comparator<Element> priority () {
    return this.priority;
  }
  
  /**
   * Returns the number of elements currently in this PriorityQueue
   * 
   * @ensure      result >= 0
   */
  public int size () {
    return orderedElements.size();
  }
  
  /**
   * Adds an element to the PriorityQueue.
   * 
   * @require     element != null
   * 
   * @ensure      Elements are added in order by this.priority()
   *              !this.isEmpty()
   *              this.size() == this.size() + 1
   */
  public void enqueue (Element element) {
    Iterator<Element> iterator = orderedElements.iterator();
    
    while (!iterator.done() && priority.compare(iterator.get(), element) <= 0) {
      iterator.advance();
    }
    
    if (!iterator.done())
      orderedElements.add(iterator, element);
    else
      orderedElements.add(element);
  }
  
  /**
   * Removes the element with the highest priority from this
   * PriorityQueue.
   * 
   * @require     !this.isEmpty()
   * 
   * @ensure      this.size() == this.size() - 1
   */
  public void serve () {
    orderedElements.remove(0);
  }
  
  /**
   * Returns a string representation of this PriorityQueue.
   * 
   * @ensure      Format will be:
   *              [last priority element, ..., first priority element]
   */
  public String toString () {
    return orderedElements.toString();
  }
  
  /**
   * Returns a copy of this PriorityQueue.
   * 
   * @ensure      All elements in this PriorityQueue are in result.
   *              this.size() == result.size()
   */
  public LinkedPriorityQueue<Element> copy () {
    LinkedPriorityQueue<Element> result = new LinkedPriorityQueue<Element> 
                                       (this.priority);
    for (Element element : orderedElements)
      result.enqueue (element);
    return result;
  }
  
  /**
   * Empties this PriorityQueue.
   * 
   * @ensure      this.size() == 0;
   */
  public void clear () {
    orderedElements = new LinkedList<Element> ();
  }
  
}
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 1

package CSCI_2125.Homework5;

import nhUtilities.containers2.*;

/**
 * This class is used to model a Set with a LinkedList.
 */
public class LinkedSet <Element> extends AbstractSet <Element>{
  
  private LinkedList<Element> list;
  private int size;
  
  public LinkedSet () {
    list = new LinkedList<Element>();
    size = 0;
  }
  
  /**
   * Add the given element to this Set.
   * @require     ele != null && this.contains(ele) == false
   * @ensure      this.contains(ele) == true
   */
  public void add (Element ele) {
    
  }
  
  /**
   * Remove the given element from this Set.
   * @require     ele != null
   * @ensure      this.contains(ele) == false
   */
  public void remove (Element ele);
  
  /**
   * Returns true if the Set contains the given element.
   * @require     ele != null
   * @ensure      Returns true if ele is contained in the Set, 
   *              else returns false
   */
  public boolean contains (Element ele);
  
   
  /**
   * Returns the number of elements in the Set.
   * @ensure      Returns the number of elements
   *              in the Set which will be >= 0.
   */
  public int size ();
  
    
  /**
   * Returns an iterator that traverses the Set.
   * @ensure      Will return an iterator for
   *              this Set.
   */
  public Iterator<Element> iterator ();
  
  /**
   * Returns an empty Set.
   * @ensure      result.size() == 0
   */
  public Set<Element> newInstance ();
  
  
  
}
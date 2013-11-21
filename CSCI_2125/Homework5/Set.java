// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

package CSCI_2125.Homework5;

import nhUtilities.containers2.*;

/**
 * This interface is used to model a Set.
 */
public interface Set <Element> {
  
  /**
   * Add the given element to this Set.
   * @require     ele != null && this.contains(ele) == false
   * @ensure      this.contains(ele) == true
   */
  public void add (Element ele);
  
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
   * Returns true if the Set contains no elements.
   * @ensure      Returns true if this.size() == 0,
   *              else returns false
   */
  public boolean isEmpty ();
  
  /**
   * Returns a Set that contains the elements of
   *   the Set and the elements of other.
   * @require     other != null
   * @ensure      All elements in the Set and in other
   *              will be included in the result.
   *              result.size() == Number of unique elements
   *                               in this and other
   */
  public Set<Element> union (Set<Element> other);
  
  /**
   * Returns a Set that contains the elements
   *   common to this and other.
   * @require     other != null
   * @ensure      Any elements common to this and other
   *              will be included in the result.
   *              No elements other than those common
   *              to this and other will be included
   *              in the result.
   */
  public Set<Element> intersection (Set<Element> other);
  
  /**
   * Returns the number of elements in the Set.
   * @ensure      Returns the number of elements
   *              in the Set which will be >= 0.
   */
  public int size ();
  
  /**
   * Returns a String representation of the Set.
   * @ensure      The result will be in the format
   *              {x, y, z}
   */
  public String toString ();
  
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
  
  /**
   * Returns a copy of the given Set.
   * @require     other != null
   * @ensure      other.equals(result)
   *              && result.equals(other)
   */
  public Set<Element> copy ();
  
}
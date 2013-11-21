// Name:       Melanie Meilleur
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/23/2011
// Assignment: Homework 2 Part I

package CSCI_2125.Homework2i;

import nhUtilities.containers2.*;

/**
 * This interface is used to model a Bag that can hold any number of Elements.
 */
public interface UnboundedBag <Element> {
  
  /**
   * Add one instance of the given element to this UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      this.isMember(ele) == true && this.size() = this.size() + 1
   *              && this.count (ele) > 0
   */
  public void add (Element ele);
  
  /**
   * Add the given element to this UnboundedBag in the specified quantity.
   * 
   * @require     ele != null, quantity > 0
   * @ensure      this.isMember(ele) == true 
   *              && this.size() = this.size() + quantity
   *              && this.count (ele) = this.count (ele) + quantity
   * 
   */
  public void add (Element ele, int quantity);
  
  /**
   * Remove one instance of the given element from this UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      this.count(ele) = this.count(ele) - 1
   *              && this.size() = this.size() - 1
   */
  public void remove (Element ele);
  
  /**
   * Remove the given element in the specified quantity from this UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      this.size() = this.size() - quantity 
   *              && this.count (ele) = this.count (ele) - quantity
   */
  public void remove (Element ele, int quantity);
  
  /**
   * Remove all instances of the given element from this UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      this.isMember (ele) == false &&
   *              this.size() = this.size() - this.count (ele) 
   *              && this.count (ele) == 0
   */
  public void removeAll (Element ele);
  
  /**
   * Remove all elements from this UnboundedBag.
   * 
   * @ensure      this.size() == 0
   */
  public void emptyBag ();
  
  /**
   * Returns true if the given element is in the UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      Returns true if this.count (ele) > 0, 
   *              else returns false
   */
  public boolean isMember (Element ele);
  
  /**
   * Returns true if all elements in the given UnboundedBag are contained 
   * in this UnboundedBag.
   * 
   * @require     otherUnboundedBag != null
   * @ensure      Returns true iff for each element (ele) in otherUnboundedBag,
   *              isMember (ele) == true
   */
  public boolean contains (UnboundedBag<Element> otherUnboundedBag);
  
  /**
   * Returns true if the UnboundedBag contains no elements.
   * 
   * @ensure      Returns true if this.size() == 0,
   *              else returns false
   */
  public boolean isEmpty ();
  
  /**
   * Returns an UnboundedBag that contains the elements of this UnboundedBag 
   * and the elements of 
   * otherUnboundedBag.
   * 
   * @require     other != null
   * @ensure      All elements in the UnboundedBag and in otherUnboundedBag
   *              will be included in the result.
   *              result.size() == Number of elements
   *                               in this and otherUnboundedBag
   */
  public UnboundedBag<Element> union (UnboundedBag<Element> otherUnboundedBag);
  
  /**
   * Returns an UnboundedBag that contains the elements common to this 
   * UnboundedBag and otherUnboundedBag.
   * 
   * @require     other != null
   * @ensure      Any elements common to this and otherUnboundedBag
   *              will be included in the result.
   *              No elements other than those common
   *              to this and otherUnboundedBag will be included
   *              in the result.
   */
  public UnboundedBag<Element> intersection (UnboundedBag<Element> 
                                             otherUnboundedBag);
  
  /**
   * Returns an UnboundedBag that contains the elements in this UnboundedBag
   * that are not contained in the otherUnboundedBag.
   * 
   * @require     other != null
   * @ensure      result.contains(this.intersection(otherUnboundedBag))
   *              && result.size() == this.intersection(otherUnboundedBag)
   */
  public UnboundedBag<Element> difference (UnboundedBag<Element> 
                                           otherUnboundedBag);
  
  /**
   * Returns the total number of elements in the UnboundedBag.
   * 
   * @ensure      Returns the number of elements
   *              in the UnboundedBag which will be >= 0.
   */
  public int size ();
  
  /**
   * Returns the count of the given element in this UnboundedBag.
   * 
   * @require     ele != null
   * @ensure      if isMember (ele) == false, returns 0
   *              else returns the number of times the given element is found
   */
  public int count (Element ele);
  
  /**
   * Returns a String representation of the UnboundedBag.
   * 
   * @ensure      The result will be in the format
   *              {x, y, z}
   */
  public String toString ();
  
  /**
   * Returns an iterator that traverses the UnboundedBag.
   * 
   * @ensure      Will return an iterator for
   *              this UnboundedBag.
   */
  public Iterator<Element> iterator ();
  
  /**
   * Returns an empty UnboundedBag.
   * 
   * @ensure      result.size() == 0
   */
  public UnboundedBag<Element> newUnboundedBag ();
  
  /**
   * Returns a copy of this UnboundedBag.
   * 
   * @ensure      result.contains(this UnboundedBag) 
   *              && result.size() == this.size()
   */
  public UnboundedBag<Element> copy ();
  
}
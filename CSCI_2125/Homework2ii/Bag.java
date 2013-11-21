// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/30/2011
// Assignment: Homework 2 Part II

package CSCI_2125.Homework2ii;

import nhUtilities.containers2.*;

/**
 * This interface is used to model a Bag that can hold any number of Elements.
 */
public interface Bag <Element> {
  
  /**
   * Add one instance of the given element to this Bag.
   * 
   * @require     element != null
   * @ensure      this.isMember(element) == true && this.size() = old.size() + 1
   *              && this.numberOf (element) == old.numberOf(element) + 1
   */
  public void add (Element element);
  
  
  /**
   * Add the given element to this Bag in the specified quantity.
   * 
   * @require     element != null, quantity >= 0
   * @ensure      this.isMember(element) == true 
   *              && this.size() == old.size() + quantity
   *              && this.numberOf (element) == this.numberOf (element) + quantity
   * 
   */
  public void add (Element element, int quantity);
  
  
  /**
   * Remove one instance of the given element from this Bag 
   * if this.isMember(element) == true.
   * 
   * @require     element != null
   * @ensure      if old.isMember(element), 
   *              this.numberOf(element) == old.numberOf(element) - 1
   *              && this.size() = this.size() - 1
   */
  public void remove (Element element);
  
  
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
  public void remove (Element element, int quantity);
  
  
  /**
   * Remove all instances of the given element from this Bag.
   * 
   * @require     element != null
   * @ensure      this.isMember (element) == false &&
   *              this.size() == old.size() - old.numberOf (element) 
   *              && this.numberOf (element) == 0
   */
  public void removeAll (Element element);
  
  
  /**
   * Remove all elements from this Bag.
   * 
   * @ensure      this.size() == 0
   */
  public void emptyBag ();
  
  
  /**
   * Returns true if the given element is in the Bag.
   * 
   * @require     element != null
   * @ensure      Returns true if this.numberOf (element) > 0, 
   *              else returns false
   */
  public boolean isMember (Element element);
  
  
  /**
   * Returns true if all elements in the given Bag are contained 
   * in this Bag.
   * 
   * @require     otherBag != null
   * @ensure      Returns true iff for each occurance of every element 
   *              in otherBag, isMember (element) == true &&
   *              numberOf(element) >= otherBag.numberOf(element)
   * 
   */  
  public boolean contains (Bag<Element> otherBag);
  
  
  /**
   * Returns true if the Bag contains no elements.
   * 
   * @ensure      Returns true if this.size() == 0,
   *              else returns false
   */
  public boolean isEmpty ();
  
  
  /**
   * Returns an Bag that contains the elements of this Bag 
   * and the elements of otherBag.
   * 
   * @require     otherBag != null
   * @ensure      All elements in the Bag and in otherBag
   *              will be included in the result in the greatest numberOf(e)
   *              that is found in either Bag.
   *              result.size() == this.size() + otherBag.size() -
   *                               this.intersection(otherBag).size()
   */
  public Bag<Element> union (Bag<Element> otherBag);
  
  
  /**
   * Returns an Bag that contains the elements common to this 
   * Bag and otherBag.
   * 
   * @require     otherBag != null
   * @ensure      Any elements common to this and otherBag
   *              will be included in the result.
   *              If this.isMember (element) && otherBag.isMember (element), 
   *              then result.isMember (element)
   *              && if this.numberOf (element) <= otherBag.numberOf (element),
   *              result.numberOf (element) == this.numberOf (element), else 
   *              result.numberOf (element) == otherBag.numberOf (element)
   *              No elements other than the least number of those common to 
   *              this and otherBag will be included in the result.
   */
  public Bag<Element> intersection (Bag<Element> otherBag);
  
  
  /**
   * Returns an Bag that contains the elements in this Bag
   * that are not contained in the otherBag.
   * 
   * @require     otherBag != null
   * @ensure      if this.isMember (element) && !otherBag.isMember (element),
   *              then result.isMember (element) 
   *              && result.numberOf (element) == this.numberOf (element)
   *              if this.isMember (element) && otherBag.isMember (element),
   *              then if otherBag.numberOf (element) >= this.numberOf (element),
   *                result.isMember (element) == false
   *              else if otherBag.numberOf (element) < this.numberOf (element),
   *                result.isMember (element) == true 
   *                && result.numberOf (element) == this.numberOf (element) -
   *                                                  otherBag.numberOf (element)
   *              result.size() == this.size() - this.intersection(otherBag).size()
   */
  public Bag<Element> difference (Bag<Element> otherBag);
  
  
  /**
   * Returns the total number of elements in the Bag.
   * 
   * @ensure      Returns the number of elements
   *              in the Bag which will be >= 0.
   *              size() = The sum of this.numberOf(e) for each element
   *                       in this Bag.
   */
  public int size ();
  
  /**
   * Returns a Bag containing the distinct entries in this Bag.
   * //Could be implemented with a Set instead to simplify the implementation
   * 
   * @ensure      this.size() == this.uniqueNumber &&
   *              this.numberOf(every element in result) == 1 &&
   *              this.contains(result) == true
   */
  public Bag<Element> uniqueEntries ();
  
  /**
   * Returns the number of distinct entries in this Bag.
   * 
   * @ensure      this.uniqueNumber() >= 0
   */
  public int uniqueNumber();
  
  
  /**
   * Returns the count of the given element in this Bag.
   * 
   * @require     element != null
   * @ensure      if isMember (element) == false, returns 0
   *              else returns the number of times the given element is found
   */
  public int numberOf (Element element);
  
  
  /**
   * Returns true if this Bag has the same elements in the same 
   * quantity as the otherBag.
   * 
   * @require     obj != null
   * @ensure      returns true iff this.contains(OtherBag)
   *              && otherBag.contains(this)
   *              else returns false
   */
  public boolean equals (Object obj);
  
  
  /**
   * Returns a String representation of the Bag.
   * 
   * @ensure      The result will be in the format
   *              {[Element A, quantity], [Element B, quantity], ...}
   */
  public String toString ();
  
  
  /**
   * Returns an iterator that traverses the Bag.
   * 
   * @ensure      Will return an iterator for
   *              this Bag.
   */
  public Iterator<Element> iterator ();
  
  
  /**
   * Returns an empty Bag.
   * 
   * @ensure      result.size() == 0
   */
  public Bag<Element> newBag ();
  
  
  /**
   * Returns a copy of this Bag.
   * 
   * @ensure      result.equals(this Bag)
   */
  public Bag<Element> copy ();
  
}
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/30/2011
// Assignment: Homework 2 Part II

package CSCI_2125.Homework2ii;

import java.lang.StringBuilder;
import nhUtilities.containers2.*;

/**
 * This abstract class is used to model a Bag that can hold any number of Elements.
 * 
 * The following methods must be implemented in any concrete class:
 * 
 * public void add (Element element, int quantity)
 * public void remove (Element element, int quantity)
 * public Iterator<Element> iterator ()
 * public int size ()
 * public Bag<Element> newBag ()
 * 
 */
public abstract class AbstractBag <Element> implements Bag <Element>{
  
  /**
   * Add one instance of the given element to this Bag.
   * 
   * @require     element != null
   * @ensure      this.isMember(element) == true && this.size() = old.size() + 1
   *              && this.numberOf (element) == old.numberOf(element) + 1
   */
  public void add (Element element) {
    this.add (element, 1);
  }
  
  
  /**
   * Remove one instance of the given element from this Bag 
   * if this.isMember(element) == true.
   * 
   * @require     element != null
   * @ensure      if old.isMember(element), 
   *              this.numberOf(element) == old.numberOf(element) - 1
   *              && this.size() = this.size() - 1
   */
  public void remove (Element element) {
    this.remove (element, 1);
  }
  
  
  
  /**
   * Remove all instances of the given element from this Bag.
   * 
   * @require     element != null
   * @ensure      this.isMember (element) == false &&
   *              this.size() == old.size() - old.numberOf (element) 
   *              && this.numberOf (element) == 0
   */
  public void removeAll (Element element) {
    this.remove (element, this.numberOf (element));
  }  
  
  
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
  public boolean contains (Bag<Element> otherBag) {
    boolean result = true;
    Iterator<Element> otherIterator = otherBag.iterator();
    
    if (this.size() >= otherBag.size()) {
      
      //Checks each element for membership and a number that could be contained
      while (result && !otherIterator.done()) {
        if (this.isMember(otherIterator.get())) {
          if (this.numberOf(otherIterator.get()) 
                < otherBag.numberOf(otherIterator.get()))
            result = false;
        }
        else
          result = false;
        otherIterator.advance();
      }      
    }
    else
      result = false;
    return result;
  }  
  
  
  /**
   * Returns true if the Bag contains no elements.
   * 
   * @ensure      Returns true if this.size() == 0,
   *              else returns false
   */
  public boolean isEmpty () {
    return this.size () == 0;
  }
  
  
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
  public Bag<Element> union (Bag<Element> otherBag) {
    Iterator <Element> otherIterator = otherBag.iterator ();
    
    Bag <Element> result = this.copy();
    
    //Add the elements of otherBag to result.
    while (!otherIterator.done()) {
      result.add(otherIterator.get());
      otherIterator.advance();
    }
    
    return result;
  }
  
  
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
  public Bag<Element> intersection (Bag<Element> otherBag) {
    Iterator <Element> thisIterator = this.iterator();
    
    Bag <Element> result = this.newBag();
    
    //Add elements to result that are in both Bags
    while (!thisIterator.done()) {
      if (otherBag.isMember(thisIterator.get())) {
        if (!result.isMember(thisIterator.get())) {
          int thisCount = this.numberOf(thisIterator.get());
          int otherCount = otherBag.numberOf(thisIterator.get());
          int common = 0;
          if (thisCount > otherCount)
            common = otherCount;
          else
            common = thisCount;        
          result.add(thisIterator.get(), common);
        }
      }
      thisIterator.advance();
    }
    
    return result;
  }
  
  
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
  public Bag<Element> difference (Bag<Element> otherBag) {
    Bag <Element> result = this.copy();
    
    Iterator<Element> iterator = this.intersection(otherBag).iterator();
    
    //Remove all items that occur in the intersection of the two bags from result
    while (!iterator.done()) {
      result.remove(iterator.get());
      iterator.advance();
    }
    
    return result;
  }
  
  
  /**
   * Returns the count of the given element in this Bag.
   * 
   * @require     element != null
   * @ensure      if isMember (element) == false, returns 0
   *              else returns the number of times the given element is found
   */
  public int numberOf (Element element) {
    Iterator<Element> thisIterator = this.iterator();
    int count = 0;
    
    //Iterates through the Bag and counts the number of the element
    while (!thisIterator.done()) {
      if (thisIterator.get().equals(element))
        count = count + 1;
      thisIterator.advance();
    }
    
    return count;
  }
  
  /**
   * Returns the number of unique entries in this Bag.
   * 
   * @ensure      uniqueNumber() <= this.size()
   *              returns uniqueEntries().size()
   */
  public int uniqueNumber() {
    return this.uniqueEntries().size();
  }   
  
  
  /**
   * Returns a Bag containing the distinct entries in this Bag.
   * 
   * Could be implemented with a Set instead to simplify the implementation, 
   * but to have all parts included in the homework, I have used a Bag.
   * 
   * @ensure      result.size() == this.uniqueNumber &&
   *              this.numberOf(every element in result) == 1 &&
   *              this.contains(result) == true
   *              All elements in result are contained in this Bag in greater or
   *              equal number to those in result.
   */
  public Bag<Element> uniqueEntries () {
    Bag<Element> result = this.newBag ();
    Iterator<Element> iterator = this.iterator();
    
    //Iterate through the Bag and add the unique elements to the result
    while(!iterator.done()) {
      if (!result.isMember(iterator.get()))
        result.add(iterator.get());
      iterator.advance();
    }
    return result;
  }
  
  /**
   * Returns a String representation of the Bag.
   * 
   * @ensure      The result will be in the format
   *              {[Element A, quantity], [Element B, quantity], ...}
   */
  public String toString () {
    StringBuilder result = new StringBuilder ("{");
    Iterator <Element> iterator = uniqueEntries().iterator();
    
    //Adds a string representation of each element to result
    while (!iterator.done()) {
      result.append("[");
      result.append(iterator.get().toString());
      result.append(", ");
      result.append(this.numberOf(iterator.get()));
      result.append("]");
      iterator.advance();
      if (iterator.hasNext())
        result.append(", ");      
    }    
    result.append("}");    
    return result.toString();
  }
  
  /**
   * Returns true if the given element is in the Bag.
   * 
   * @require     element != null
   * @ensure      Returns true if this.numberOf (element) > 0, 
   *              else returns false
   */
  public boolean isMember (Element element) {
    Iterator<Element> thisIterator = this.iterator();
    boolean result = false;
    while (!result && !thisIterator.done()) {
      if (thisIterator.get().equals(element))
        result = true;
      thisIterator.advance();
    }
    return result;
  }  
  
  
  /**
   * Returns true if this Bag has the same elements in the same 
   * quantity as the otherBag.
   * 
   * @require     obj != null
   * @ensure      returns true iff this.contains(OtherBag)
   *              && otherBag.contains(this)
   *              else returns false
   */
  public boolean equals (Object obj) {
    boolean result = false;
    if (obj instanceof Bag) {
      //unchecked cast: is instanceof Bag - Element type is checked by contains
      //through invoking the isMember method
      Bag<Element> otherBag = (Bag<Element>)obj; 
      result = this.contains(otherBag) && otherBag.contains(this.copy());
    }
    return result;
  }
  
  
  /**
   * Returns a copy of this Bag.
   * 
   * @ensure      result.equals(this Bag)
   */
  public Bag<Element> copy () {
    Bag <Element> result = this.newBag();
    
    Iterator <Element> thisIterator = this.iterator();
    
    //Adds every element in this Bag to result
    while (!thisIterator.done()) {
      result.add(thisIterator.get());
      thisIterator.advance();
    }    
    return result;
  }  
}
// Name:       Melanie Meilleur
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/16/2011
// Assignment: Homework 1

package CSCI_2125.Homework1;

import nhUtilities.containers2.*;


/**
 * An Abstract class that models a Set.
 */
public abstract class AbstractSet<Element> implements Set<Element> {
  
  /**
   * Returns true if the Set contains no elements.
   * 
   * @ensure      Returns true if this.size() == 0,
   *              else returns false
   */
  public boolean isEmpty () {
    return this.size() == 0;
  }
  
  
  /**
   * Returns a Set that contains the elements of the Set and the elements of other.
   * 
   * @require     other != null
   * @ensure      All elements in other that are not in the Set will be added
   *              to the end of the result.  All elements that appear in either 
   *              Set will be in result.
   *              result.size() == Number of unique elements in this and other.
   *              
   */
  public Set<Element> union (Set<Element> other) {
    Iterator<Element> thisIterator = this.iterator();
    Iterator<Element> otherIterator = other.iterator();
    
    Set<Element> result = this.copy();
    
    //Add the elements of other Set to the result.
    while(!otherIterator.done()){
      result.add(otherIterator.get());
      otherIterator.advance();
    }
    
    return result;
  }
  
  
  /**
   * Returns a Set that contains the elements common to this and other.
   * 
   * @require     other != null
   * @ensure      Any elements common to this and other will be included in result.
   *              No elements other than those common to this and other will be 
   *              included in result.
   *              Elements will be ordered in the way they appear in the Set
   *              regardless of the order in other.
   */
  public Set<Element> intersection (Set<Element> other) {
    Iterator<Element> thisIterator = this.iterator();
    
    Set<Element> result = this.newInstance();
    
    while (!thisIterator.done()) {
      if (other.contains(thisIterator.get()))
        result.add(thisIterator.get());
      thisIterator.advance();
    }
    
    return result;
  }
  
  
  /**
   * Returns a copy of the given Set.
   * 
   * @require     other != null
   * @ensure      other.equals(result) && result.equals(other)
   */
  public Set<Element> copy () {
    Set<Element> result = this.newInstance();
    
    Iterator<Element> thisIterator = this.iterator();
    
    while (!thisIterator.done()) {
      result.add(thisIterator.get());
      thisIterator.advance();
    }
    
    return result;
  }
  
  
  /**
   * Returns a String representation of the Set.
   * 
   * @ensure      The result will be in the format {x, y, z}
   */
  public String toString () {
    String result = "{";
    
    Iterator<Element> thisIterator = this.iterator();
    
    while (!thisIterator.done()) {
      result = result + thisIterator.get();
      thisIterator.advance();
      if (thisIterator.hasNext())
        result = result + ", ";      
    }
    
    result = result + "}";
    
    return result;
  }
  
}
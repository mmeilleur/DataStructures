// Name:       Melanie Meilleur
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/16/2011
// Assignment: Homework 1

package CSCI_2125.Homework1;

import nhUtilities.containers2.*;

/**
 * Abstract Class for an Iterator.
 */
public abstract class AbstractIterator<Element> implements Iterator<Element> {
  
  /**
   * Throw UnsupportedOperationException.  Equals is not implemented
   * for this Iterator.
   */
  public boolean equals (Object obj){
    throw new UnsupportedOperationException("Not implemented");
  }
  
  /**
   * Throw UnsupportedOperationException.  Traverses is not implemented
   * for this Iterator.
   */
  public boolean traverses (Object container){
    throw new UnsupportedOperationException("Not implemented");
  }
  
  /**
   * Throw UnsupportedOperationException.  Clone is not implemented
   * for this Iterator.
   */
  public Object clone (){
    throw new UnsupportedOperationException("Not implemented");
  }
  
  /**
   *Throw UnsupportedOperationException.  SetEqualTo is not implemented
   * for this Iterator.
   */
  public void setEqualTo (Iterator<Element> other){
    throw new UnsupportedOperationException("Not implemented");
  }
  
  /**
   * There are more elements to traverse. Equivalent to !this.done().
   */
  public boolean hasNext (){
    return !this.done();
  }
  
  /**
   * Return the current element and advance to the next.  Implemented
   * only to satisfy java.util.Iterator<Element>.
   * @require    !this.done()
   */
  public Element next (){
    Element result = this.get();
    this.advance();
    return result;
    
  }
  
  /**
   * Throw UnsupportedOperationException.  Remove is not implemented
   * for this Iterator.
   */
  public void remove (){
    throw new UnsupportedOperationException("Not implemented");
  }
}  


// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

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
   * @require     element != null && this.contains(ele) == false
   * @ensure      this.contains(element) == true
   */
  public void add (Element element) {
    if (!this.contains(element)) {
      list.add(element);
      size = size + 1;
    }
  }
  
  /**
   * Remove the given element from this Set.
   * @require     element != null
   * @ensure      this.contains(element) == false
   */
  public void remove (Element element) {
    list.remove(element);
    size = size - 1;
  }
  
  /**
   * Returns true if the Set contains the given element.
   * @require     element != null
   * @ensure      Returns true if element is contained in the Set, 
   *              else returns false
   */
  public boolean contains (Element element) {
    return list.indexOf(element) != -1;
  }
  
  /**
   * Returns the index of the given element.
   * @require     element != null
   * @ensure      Returns the index of the element if found, -1 if not
   */
  public int indexOf (Element element) {
    return list.indexOf(element);
  }
  
  /**
   * Returns the element at the given index.
   * @require     index >= 0 && index < this.size()
   * @ensure      Returns the requested element
   */
  public Element get (int index) {
    return list.get(index);
  }
  
   
  /**
   * Returns the number of elements in the Set.
   * @ensure      Returns the number of elements
   *              in the Set which will be >= 0.
   */
  public int size () {
    return this.size;
  }
  
    
  /**
   * Returns an iterator that traverses the Set.
   * @ensure      Will return an iterator for
   *              this Set.
   */
  public Iterator<Element> iterator () {
    return list.iterator();
  }
  
  /**
   * Returns an empty Set.
   * @ensure      result.size() == 0
   */
  public LinkedSet<Element> newInstance () {
    return new LinkedSet<Element>();
  }  
  
  
}
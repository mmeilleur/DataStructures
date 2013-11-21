// Name:       Melanie Meilleur
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/16/2011
// Assignment: Homework 1

package CSCI_2125.Homework1;

import nhUtilities.containers2.*;


/**
 * Implementation of a Set for Integers using an array. 
 */
public class IntegerArraySet extends AbstractSet<Integer> {
  
  private int size;
  private int[] set;
  
  /**
   * Creates a new Empty Set with the given size as the maximum accepted value.
   * 
   * @require     initialSize > 0
   * @ensure      this.isEmpty() == true
   *              this.size() == 0
   **/
  public IntegerArraySet(int initialSize) {
    this.size = 0;
    set = new int[initialSize];
  }
  
  /**
   * Creates a new Empty Set.
   * 
   * @ensure      this.isEmpty() == true
   *              this.size() == 0
   **/
  public IntegerArraySet() {
    this(10);
  }
  
  /**
   * Add the given element to this Set.
   * 
   * @require     x != null && this.contains(x) == false
   * @ensure      this.contains(x) == true
   */
  public void add (Integer x) {
    if (!this.contains(x)) {
      if (size == set.length)
        this.expand();
      
      set[size] = x;
      size = size + 1;
    }
  }
  
  /**
   * Remove the given element from this Set.
   * 
   * @require     x != null
   * @ensure      this.contains(x) == false
   */
  public void remove (Integer x) {
    int index = -1;
    for (int i = 0; i < size; i++) {
      if (set[i] == x)
        index = i;
    }
    if (index >= 0) {
      for (int i = index; i < size - 1; i++) 
        set[i] = set[i + 1];
      this.size = this.size - 1;      
    }
  }
  
  
  /**
   * Test an element for membership. 
   **/
  public boolean contains (Integer x) {
    boolean result = false;
    for (int i = 0; i < size && !result; i++) {
      if (set[i] == x)
        result = true;
    }
    return result;
  }
  
  /**
   * Returns an empty Set.
   * 
   * @ensure      result.size() == 0
   */
  public IntegerArraySet newInstance () {
    return new IntegerArraySet();
  }
  
  /**
   * Return the number of elements in the set.
   **/
  public int size () {
    return this.size;
  }
  
  /**
   * A private method to grow the size of the array by 5.
   * 
   *@ensure      The array will grow by 5 && all elements in the old will be
   *             in the new.
   */
  private void expand () {
    int[] result = new int[set.length + 5];
    for (int i = 0; i < size; i++)
      result[i] = set[i];
    set = result;
  }
  
  /**
   * Returns an iterator that traverses the Set.
   * 
   * @ensure      Will return an iterator for this Set.
   */
  public Iterator<Integer> iterator () {
    return new IntegerArraySetIterator();
  }
  
  /**
   * Private class implements an Iterator for IntegerArraySet class.
   */
  private class IntegerArraySetIterator extends AbstractIterator<Integer> {
    
    private int position;
    
    /**
     * Creates a new Iterator that starts at the beginning of the Set.
     * 
     * @ensure      position == 0
     */
    public IntegerArraySetIterator () {
      this.reset();
    }
    
    /**
     * Set this Iterator to point to the first position.
     * 
     * @ensure      position == 0
     */
    public void reset () {
      this.position = 0;
    }
    
    /**
     * Move this Iterator to the element after the current position.
     * 
     * @require     !this.done()
     */
    public void advance () {
      this.position = this.position + 1;
    }
    
    /**
     * Returns true if there are no more elements in the Set.
     * 
     * @ensure      position <= IntegerArraySet.this.size()
     */
    public boolean done () {
      return position == IntegerArraySet.this.size();
    }
    
    /**
     * Returns the element this Iterator currently points to.
     */
    public Integer get () {
      return IntegerArraySet.this.set[position];
    }
  }
}


// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

//package CSCI_2125.Homework5;

/**
 * This interface models a Dictionary that stores data in Key, Value pairs.
 */
public interface Dictionary <Key, Value> {
  
  /**
   * Adds an entry to the Dictionary.  If the key already exists, replaces
   * the value with the provided value.
   * 
   * @require     key != null
   * 
   * @ensure      <Key, Value> pair is added to the Dictionary
   *              if key exists, then value will be replaced
   *              if not, it is added and countEntries = countEntries + 1
   */
  public void add (Key key, Value value);
  
  /**
   * Removes an entry from the Dictionary.
   * 
   * @require     key != null
   * 
   * @ensure      <Key, Value> pair is not in the Dictionary
   */
  public void remove (Key key);
  
  /**
   * Returns the value of a given key.
   * 
   * @require     key != null && this.contains(key)
   * 
   * @ensure      if key is in the Dictionary, returns associated value
   */
  public Value get (Key key);
  
  /**
   * Returns true if the given key is found in the Dictionary.
   * 
   * @require     key != null
   * 
   * @ensure      returns true iff the key is found in this Dictionary.
   */
  public boolean contains (Key key);
  
  /**
   * Returns the number of entries in this Dictionary.
   * 
   * @ensure      returns the number of keys in this Dictionary
   *              Only accurate if the number of entries is in the range of long
   */
  public long countEntries ();
  
  /**
   * Returns true if there are no entries in this Dictionary.
   * 
   * @ensure      returns countEntries == 0;
   */
  public boolean isEmpty ();
  
}
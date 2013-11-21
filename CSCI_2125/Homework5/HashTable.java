// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

//package CSCI_2125.Homework5;

import nhUtilities.containers2.*;

/**
 * This class models a Dictionary using a hash table for fast lookups.
 * 
 * @require     Number of entries must not exceed the range of Long numbers.
 */
public class HashTable <Key, Value> implements Dictionary <Key, Value> {
  
  private LinkedSet<Pair<Key, Value>>[] table;
  private long countEntries;
  
  /**
   * Constructs a new HashTable with entries possible entries.
   * 
   * @require     entries is in the range of Long
   * 
   * @ensure      This HashTable can hold entries entries
   */
  public HashTable (long entries) {    
    table = new LinkedSet[(int)(entries/4)]; 
                                 //Unchecked conversion: checked
                                 //Only Pair <Key, Value> entries will be added,
                                 //but must instantiate array with raw type
    
    //Fill the array with empty sets
    for (int i = 0; i < table.length; i = i + 1) {
      table[i] = new LinkedSet<Pair<Key, Value>> ();
    }
    countEntries = 0;
  }

  /**
   * Adds an entry to the HashTable.  If the key already exists, replaces
   * the value with the provided value.
   * 
   * @require     key != null, countEntries <= table.length
   * 
   * @ensure      <Key, Value> pair is added to the HashTable
   *              if key exists, then value will be replaced
   */
  private void add (Key key, Value value) {
    Pair<Key, Value> entry = new Pair<Key, Value>(key, value);
    if (!this.contains(key)) {
      getSet(key).add(entry);
      countEntries = countEntries + 1;
    }
    else {
      getSet(key).get(indexOfKey(key)).setValue(value);
    }    
  }
  
  
  /**
   * Private helper method to compute hash index value
   */
  private int hashIndex (Key key) {
    int index = (int)(HashUtil.hash(key.toString()) % (long)table.length);
    return index;
  }
  
  /**
   * Private helper method to return the Set at the hashIndex
   */
  private LinkedSet<Pair<Key, Value>> getSet (Key key) {
    return table[hashIndex(key)];
  }

  
  /**
   * Removes an entry from the HashTable.
   * 
   * @require     key != null
   * 
   * @ensure      <Key, Value> pair is not in the HashTable
   */
  public void remove (Key key) {
    if (this.contains(key)) {      
      getSet(key).remove(getSet(key).get(indexOfKey(key)));
      countEntries = countEntries - 1;
    }
  }
  
  /**
   * Returns the value of a given key.
   * 
   * @require     key != null && this.contains(key)
   * 
   * @ensure      if key is in the HashTable, returns associated value
   */
  public Value get (Key key) {
    int index = indexOfKey(key);
    return getSet(key).get(index).value();
  }
  
  /**
   * Returns true if the given key is found in the HashTable.
   * 
   * @require     key != null
   * 
   * @ensure      returns true iff the key is found in this HashTable.
   */
  public boolean contains (Key key) {
    boolean result = true;
    if (table[hashIndex(key)].isEmpty())
      result = false;
    else if (indexOfKey(key) == -1)
      result = false;
    return result;
  }
  
  /**
   * Private helper method that returns the index of the given key in the 
   * LinkedSet in which the key is stored.
   */
  private int indexOfKey (Key key) {
    LinkedSet<Pair<Key, Value>> set = getSet(key);
    int index = -1;
    //Loops through the set to find the key
    for (int i = 0; i < set.size(); i = i + 1) {
      if (!set.isEmpty() && set.get(i).isKey(key))
        index = i;
    }
    return index;
  }
  
  /**
   * Returns the number of entries in this HashTable.
   * 
   * @ensure      returns the number of keys in this HashTable
   *              Only accurate if the number of entries is in the range of long
   */
  public long countEntries () {
    return this.countEntries;
  }
  
  /**
   * Returns true if there are no entries in this HashTable.
   * 
   * @ensure      returns countEntries == 0;
   */
  public boolean isEmpty () {
    return countEntries == 0;
  }
  
  /**
   * A private helper class to store Key, Value pairs.
   */
  private class Pair<Key, Value> {
    
    private Key key;
    private Value value;
    
    public Pair (Key key, Value value) {
      this.key = key;
      this.value = value;
    }
    
    /**
     * Returns the key.
     */
    public Key key () {
      return this.key;
    }
    
    /**
     * Returns true if the given key equals this.key
     */
    public boolean isKey (Key otherKey) {
      return this.key.equals(otherKey);
    }
    
    /**
     * Returns the value.
     */
    public Value value () {
      return this.value;
    }
    
    /**
     * Changes the value.
     */
    public void setValue (Value value) {
      this.value = value;
    }
    
  } //End Pair class
  
}
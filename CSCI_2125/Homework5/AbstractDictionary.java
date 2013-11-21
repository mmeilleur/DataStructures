//package c2125.Homework5;

/**
 * This abstract class models a Dictionary that stores data in Key, Value pairs.
 * Only composite methods are contained herein.
 */
public abstract class AbstractDictionary <Key, Value> implements 
                               Dictionary <Key, Value>{
       
  /**
   * Returns true if there are no entries in this Dictionary.
   * 
   * @ensure      returns countEntries == 0;
   */
  public boolean isEmpty () {
    return this.countEntries() == 0;
  }
  
}
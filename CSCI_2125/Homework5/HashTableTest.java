// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

package CSCI_2125.Homework5;

import junit.framework.TestCase;

/**
 * A test class for HashTable
 */
public class HashTableTest extends TestCase {
  
  private HashTable<String, Integer> smallStringInt;
  private HashTable<String, String> largeStringString;
  private HashTable<Integer, Integer> mediumIntInt;
  
  /**
   * Creates HashTables to use in testing
   */
  public void setUp () {
    
    smallStringInt = new HashTable<String, Integer> (10);
    largeStringString = new HashTable<String, String> (15000);
    mediumIntInt = new HashTable<Integer, Integer> (751);
    
    //Added after initial add testing
    
    //Fill largeStringString with incremented "String1", "1String" pairs
    for (int i = 0; i < 15000; i = i + 1) {
      largeStringString.add("String" + i, i + "String");
    }
    //Fill mediumIntInt with increasing, decreasing pairs
    int j = 751;
    for (int i = 0; i < 751; i = i + 1) {      
      mediumIntInt.add(i, j);
      j = j - 1;
    }
  }
  
  /**
   * Test isEmpty method & initial state
   * 
   * Also tests countEntries method for countEntries == 0 
   */
  public void testIsEmpty() {
    
    assertTrue(smallStringInt.isEmpty());
    assertTrue(!largeStringString.isEmpty());
    assertTrue(!mediumIntInt.isEmpty());
    
  }
  
  /**
   * Test initial add and contains() & get() after initial states
   */
  public void testAdd() {
    
    smallStringInt.add("Extra", 5);
    //Test using contains && countEntries
    assertTrue(smallStringInt.contains("Extra"));
    assertTrue(smallStringInt.countEntries() == 1);
    
    smallStringInt.add("Silence", 7);
    smallStringInt.add("Community", 9);
    smallStringInt.add("Sin", 3);
    smallStringInt.add("Adds", 4);
    smallStringInt.add("I", 1);
    smallStringInt.add("Of", 2);
    smallStringInt.add("Peanut", 6);
    smallStringInt.add("Measures", 8);
    smallStringInt.add("Treasuries", 10);
    assertTrue(smallStringInt.contains("Measures"));
    assertTrue(smallStringInt.countEntries() == 10);
    
    //minor testing of get to test add overwrite
    assertTrue(smallStringInt.get("Of") == 2);
    assertTrue(smallStringInt.get("Sin") == 3);
    assertTrue(smallStringInt.contains("Sin"));
    smallStringInt.add("Sin", 23);
    //Check changed value for overwrite case
    assertTrue(smallStringInt.get("Sin") == 23);
    assertTrue(smallStringInt.contains("Sin"));
    //Check unchanged size for overwrite case
    assertTrue(smallStringInt.countEntries() == 10);
    
    //Test state of different sizes after large/iterated add
    assertTrue(largeStringString.countEntries() == 15000);
    assertTrue(largeStringString.get("String1001").equals("1001String"));
    assertTrue(largeStringString.contains("String1001"));
    assertTrue(largeStringString.contains("String12464"));
    assertTrue(mediumIntInt.countEntries() == 751);
    assertTrue(mediumIntInt.get(750) == 1);
    assertTrue(mediumIntInt.get(0) == 751);
    assertTrue(mediumIntInt.contains(342));
    assertTrue(mediumIntInt.get(342) == 409);
    
    
  }
  
  /**
   * Test the remove method
   * 
   * Will continue to test contains, countEntries, and get
   */
  public void testRemove() {
    
    //Remove one from many
    largeStringString.remove("String1001");
    assertFalse(largeStringString.contains("String1001"));
    assertTrue(largeStringString.countEntries() == 14999);
    
    //Remove one from none
    assertFalse(smallStringInt.contains("Yellow"));
    smallStringInt.remove("Yellow");
    assertFalse(smallStringInt.contains("Yellow"));
    assertTrue(smallStringInt.isEmpty());
    
    //Remove one from one
    smallStringInt.add("Orange", 6);
    assertTrue(smallStringInt.contains("Orange"));
    assertTrue(smallStringInt.get("Orange") == 6);
    assertTrue(smallStringInt.countEntries() == 1);
    smallStringInt.remove("Orange");
    assertFalse(smallStringInt.contains("Orange"));
    assertTrue(smallStringInt.countEntries() == 0);
    assertTrue(smallStringInt.isEmpty());
    
    //Remove several from several
    assertTrue(mediumIntInt.contains(0));
    mediumIntInt.remove(0);
    assertFalse(mediumIntInt.contains(0));
    assertTrue(mediumIntInt.countEntries() == 750);
    mediumIntInt.remove(30);
    mediumIntInt.remove(355);
    mediumIntInt.remove(234);
    mediumIntInt.remove(42);
    mediumIntInt.remove(750);
    assertTrue(mediumIntInt.countEntries() == 745);
    assertFalse(mediumIntInt.contains(42));
    
    //Remove non-existant entry
    mediumIntInt.remove(42);
    assertFalse(mediumIntInt.contains(42));
    assertTrue(mediumIntInt.countEntries() == 745);
    
  }
  
  /**
   * More get() testing
   */
  public void testGet() {
    
    assertEquals(largeStringString.get("String0"), "0String");
    assertEquals(largeStringString.get("String102"), "102String");
    assertEquals(largeStringString.get("String555"), "555String");
    assertEquals(largeStringString.get("String14999"), "14999String");
    assertEquals(largeStringString.get("String5000"), "5000String");
    assertEquals(largeStringString.get("String1000"), "1000String");
    assertEquals(largeStringString.get("String4"), "4String");
    assertTrue(mediumIntInt.get(111) == 640);
    assertTrue(mediumIntInt.get(2) == 749);
    assertTrue(mediumIntInt.get(600) == 151);
    assertTrue(mediumIntInt.get(42) == 709);
    
  }
  
  /**
   * More contains() testing
   */
  public void testContains() {
    
    assertTrue(largeStringString.contains("String0"));
    assertFalse(largeStringString.contains("String"));
    assertTrue(largeStringString.contains("String14999"));
    assertTrue(largeStringString.contains("String357"));
    assertTrue(mediumIntInt.contains(0));
    assertFalse(mediumIntInt.contains(3644536));
    assertTrue(mediumIntInt.contains(750));
    assertTrue(mediumIntInt.contains(554));
    
  } 
  
}
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import junit.framework.TestCase;

/**
 * A test class for LinkedPriorityQueue.  Also tests IntegerComparator and
 * StringComparator.
 */
public class LinkedPriorityQueueTest extends TestCase {
  
  private LinkedPriorityQueue<Integer> emptyInt;
  private LinkedPriorityQueue<Integer> oneInt;
  private LinkedPriorityQueue<Integer> severalInt;
  private LinkedPriorityQueue<String> emptyStr;
  private LinkedPriorityQueue<String> oneStr;
  private LinkedPriorityQueue<String> severalStr;
  
  //Creates a variety of containers to use in testing
  protected void setUp () {
    
    emptyInt = new LinkedPriorityQueue<Integer> (new IntegerComparator());
    oneInt = new LinkedPriorityQueue<Integer> (new IntegerComparator());
    severalInt = new LinkedPriorityQueue<Integer> (new IntegerComparator());
    emptyStr = new LinkedPriorityQueue<String> (new StringComparator());
    oneStr = new LinkedPriorityQueue<String> (new StringComparator());
    severalStr = new LinkedPriorityQueue<String> (new StringComparator());
    
    //After testing enqueue
    oneInt.enqueue(33);
    severalInt.enqueue(35);
    severalInt.enqueue(12);
    severalInt.enqueue(235);
    severalInt.enqueue(42);
    severalInt.enqueue(3);
    oneStr.enqueue("Fox");
    severalStr.enqueue("Jackalope");
    severalStr.enqueue("Zebra");
    severalStr.enqueue("Alligator");
    severalStr.enqueue("Cat");
  }
  
  /**
   * Test isEmpty
   */
  public void testIsEmpty() {
    assertTrue(emptyInt.isEmpty());
    assertTrue(emptyStr.isEmpty());
  }
  
  /**
   * Test toString
   */
  public void testToString() {
    //Empty case
    assertTrue(emptyInt.toString().equals("[]"));
    //One item case
    assertTrue(oneInt.toString().equals("[33]"));
    //Several item case
    assertTrue(severalInt.toString().equals("[3, 12, 35, 42, 235]"));
  }
  
  /**
   * Test enqueue - also tests comparators 
   */
  public void testEnqueue() {
    //Base case - enqueue first item
    emptyInt.enqueue(55);
    assertTrue(emptyInt.toString().equals("[55]"));
    
    //Enqueue higher priority
    emptyInt.enqueue(2);
    assertTrue(emptyInt.toString().equals("[2, 55]"));
    
    //Enqueue lower priority
    emptyInt.enqueue(100);
    assertTrue(emptyInt.toString().equals("[2, 55, 100]"));
    
    //Enqueue mid priority
    emptyInt.enqueue(37);
    assertTrue(emptyInt.toString().equals("[2, 37, 55, 100]"));
    
    //Enqueue same priority
    emptyInt.enqueue(55);
    assertTrue(emptyInt.toString().equals("[2, 37, 55, 55, 100]"));
    
    //Test enqueue with Strings
    emptyStr.enqueue("Alice"); //initial
    assertTrue(emptyStr.toString().equals("[Alice]"));
    emptyStr.enqueue("Abraham"); //higher
    assertTrue(emptyStr.toString().equals("[Abraham, Alice]"));
    emptyStr.enqueue("Jacob"); //lower
    assertTrue(emptyStr.toString().equals("[Abraham, Alice, Jacob]"));
    emptyStr.enqueue("Ezra"); //mid
    assertTrue(emptyStr.toString().equals("[Abraham, Alice, Ezra, Jacob]"));
    emptyStr.enqueue("Alice"); //same
    assertTrue(emptyStr.toString().equals("[Abraham, Alice, Alice, Ezra, Jacob]"));
    
  }
  
  /**
   * Tests the size method
   */
  public void testSize() {
    //Test empty
    assertTrue(emptyInt.size() == 0);
    //Test one
    assertTrue(oneInt.size() == 1);
    //Test several
    assertTrue(severalInt.size() == 5);
    //Test size after enqueue
    oneInt.enqueue(34);
    assertTrue(oneInt.size() == 2);
    
    //Test size after serve is tested in serve testing
    
  }
  
  /**
   * Test highest method - can not test empty case.  Contract requires highest 
   * only be invoked when isEmpty is false.
   */
  public void testHighest() {
    //Test one item in queue
    assertTrue(oneInt.highest() == 33);
    //Test multiple items in queue
    assertTrue(severalInt.highest() == 3);
  }
  
  /**
   * Test serve (removes the highest) - contract requires not empty.
   */
  public void testServe() {
    //Test removing one item from a queue of 1
    oneStr.serve();
    assertTrue(oneStr.isEmpty());
    assertEquals(oneStr.toString(), "[]");
    assertTrue(oneStr.size() == 0);
    
    //Test removing one item from a queue of several
    assertTrue(severalStr.size() == 4);
    severalStr.serve();
    assertFalse(severalStr.isEmpty());
    assertTrue(severalStr.size() == 3);
    assertEquals(severalStr.toString(), "[Cat, Jackalope, Zebra]");
    
    //Test removing multiple items from a queue of several
    severalInt.serve();
    severalInt.serve();
    assertTrue(severalInt.size() == 3);
    assertTrue(severalInt.highest() == 35);
  }
  
  /**
   * Test copy
   */
  public void testCopy() {
    oneInt = severalInt.copy();
    assertEquals(oneInt.toString(), severalInt.toString());
    assertTrue(oneInt.size() == severalInt.size());
    assertEquals(oneInt.highest(), severalInt.highest());
  }
  
}
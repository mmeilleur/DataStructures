// Name:       Melanie Meilleur
// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/16/2011
// Assignment: Homework 1

package CSCI_2125.Homework1;

import junit.framework.TestCase;

/**
 * A test class for Set.
 */
public class SetTest extends TestCase {
  
  private IntegerArraySet empty;
  private IntegerArraySet one;
  private IntegerArraySet two;
  private IntegerArraySet ten;
  private IntegerArraySet fifteen;
  private IntegerArraySet sixteen;
  private IntegerArraySet twenty;
  private IntegerArraySet twenty3;
  
  private String twentyAndTwo;
  private String twoAndTwenty;
  private String fifteenAndTwenty;
  private String twentyAndFifteen;
  
  //Creates a variety of Sets to use in testing using both constructors.
  protected void setUp () {
    empty = new IntegerArraySet ();     //an empty Set
    one = new IntegerArraySet (1);      //a single-element Set
    two = new IntegerArraySet ();       //a two-element Set
    ten = new IntegerArraySet ();       //a Set that can hold 10 elements to start
    fifteen = new IntegerArraySet (15); //a fifteen-element Set
    sixteen = new IntegerArraySet (16); //an empty Set that can hold 16 elements
    twenty = new IntegerArraySet (20);  //a twenty-element Set
    
    //Fill the Set one with integer 99
    one.add(99);
    
    //Fill the Set two with integers 6 and -3
    two.add(6);
    two.add(-3);
    
    //Fill the Set fifteen with integers from -5 to 9
    for (int i = -5; i < 10; i++) 
      fifteen.add(i);
    
    //Fill the Set twenty with even integers from 0 to 38
    for (int i = 0; i < 40; i = i + 2)
      twenty.add(i);
    
    //Create Strings for Union comparison
    twentyAndTwo = "{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, "
      + "30, 32, 34, 36, 38, -3}";
    twoAndTwenty = "{6, -3, 0, 2, 4, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, "
      + "30, 32, 34, 36, 38}";
    fifteenAndTwenty = "{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "
      + "12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38}";
    twentyAndFifteen = "{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, "
      + "30, 32, 34, 36, 38, -5, -4, -3, -2, -1, 1, 3, 5, 7, 9}";
  }
  
  /**
   * Tests the toString method at the boundaries and general cases
   */
  public void testToString() {
    //Test empty Set
    assertTrue (empty.toString().equals("{}"));
    assertTrue (sixteen.toString().equals("{}"));
    
    //Test minimal Set
    assertTrue (one.toString().equals("{99}"));
    
    //Test any Set
    assertTrue (two.toString().equals("{6, -3}"));
    assertTrue (fifteen.toString().equals("{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, " + 
                                          "5, 6, 7, 8, 9}"));
  }
  
  
  /**
   * Tests the add method for general cases and duplicates
   */
  public void testAdd() {
    //Test initial state
    assertEquals (ten.size(), 0);
    
    //Test negative integer
    ten.add(-1);
    assertEquals (ten.size(), 1);
    assertTrue (ten.toString().equals("{-1}"));
    
    //Test duplicates
    ten.add(-1);
    assertEquals (ten.size(), 1);
    assertTrue (ten.toString().equals("{-1}"));
    
    //Test zero
    ten.add(0);
    assertEquals (ten.size(), 2);
    assertTrue (ten.toString().equals("{-1, 0}"));
    
    //Test other integers
    ten.add(1);
    assertEquals (ten.size(), 3);
    assertTrue (ten.toString().equals("{-1, 0, 1}"));
    
    //Test filled set
    ten.add(30);    
    ten.add(523);
    ten.add(-6);
    ten.add(42);
    ten.add(3);
    ten.add(33);
    ten.add(333);
    assertEquals (ten.size(), 10);
    assertTrue (ten.toString().equals("{-1, 0, 1, 30, 523, -6, 42, 3, 33, 333}"));
  }
  
  /**
   * Tests the remove method at the boundaries and general cases
   */
  public void testRemove() {
    //Remove any element
    fifteen.remove (-1);
    assertEquals (fifteen.size(), 14);
    assertTrue (fifteen.toString().equals("{-5, -4, -3, -2, 0, 1, 2, 3, 4, 5, " + 
                                          "6, 7, 8, 9}"));
    //Remove first element
    fifteen.remove (-5);
    assertEquals (fifteen.size(), 13);
    assertTrue (fifteen.toString().equals("{-4, -3, -2, 0, 1, 2, 3, 4, 5, " + 
                                          "6, 7, 8, 9}"));
    //Remove last element
    fifteen.remove (9);
    assertEquals (fifteen.size(), 12);
    assertTrue (fifteen.toString().equals("{-4, -3, -2, 0, 1, 2, 3, 4, 5, " + 
                                          "6, 7, 8}"));
    
    //Remove element not contained in the Set
    fifteen.remove (35);
    assertEquals (fifteen.size(), 12);
    assertTrue (fifteen.toString().equals("{-4, -3, -2, 0, 1, 2, 3, 4, 5, " + 
                                          "6, 7, 8}"));    
  }
  
  /**
   * Tests the contains method at the boundaries and general cases
   */
  public void testContains() {
    //Test first element
    assertTrue (fifteen.contains(-5));
    
    //Test last element
    assertTrue (fifteen.contains(9));
    
    //Test any element
    assertTrue (fifteen.contains(5));
    
    //Test not present element
    assertFalse (fifteen.contains(35));
  }
  
  /**
   * Tests the isEmpty method at the boundaries and general cases
   */
  public void testIsEmpty() {
    //Test empty
    assertTrue (empty.isEmpty());
    
    //Test empty of bigger size
    assertTrue (sixteen.isEmpty());
    
    //Test one element
    assertFalse (one.isEmpty());
    
    //Test many elements
    assertFalse (fifteen.isEmpty());
  }
  
  /**
   * Tests the union method, the expand method and the private iterator class
   */
  public void testUnion() {
    //Test the union of two empty Sets
    assertTrue (empty.union(sixteen).toString().equals("{}"));
    
    //Test the union of an empty set and a small filled Set (returns small Set)
    assertTrue (empty.union(one).toString().equals(one.toString()));
    assertTrue (one.union(empty).toString().equals(one.toString()));
    
    //Test the union of an empty set and a larger filled Set
    assertEquals (empty.union(twenty).toString(), twenty.toString());
    assertEquals (twenty.union(empty).toString(), twenty.toString());
    
    //Test the union of two small filled Sets with no common elements
    assertTrue (one.union(two).toString().equals("{99, 6, -3}"));
    assertTrue (two.union(one).toString().equals("{6, -3, 99}"));
    
    //Test the union of one small filled Set and one large filled Set with common
    //elements
    assertTrue (two.union(twenty).toString().equals(twoAndTwenty));
    assertTrue (twenty.union(two).toString().equals(twentyAndTwo));
    
    //Test the union of two large filled Sets with common elements
    assertTrue (fifteen.union(twenty).toString().equals(fifteenAndTwenty));
    assertTrue (twenty.union(fifteen).toString().equals(twentyAndFifteen));
  }
  
  /**
   * Tests the intersection method and by extension the private iterator class
   */
  public void testIntersection() {
    //Test two empty Sets
    assertTrue (empty.intersection(sixteen).isEmpty());
    
    //Test one empty and one filled Set
    assertTrue (empty.intersection(fifteen).isEmpty());
    
    //Test two filled Sets with no common elements
    assertTrue (one.intersection(two).isEmpty());
    
    //Test two filled Sets with common elements
    assertTrue (fifteen.intersection(twenty).toString().equals("{0, 2, 4, 6, 8}"));
    assertTrue (two.intersection(fifteen).toString().equals("{6, -3}"));
    assertTrue (two.intersection(twenty).toString().equals("{6}"));
  }
  
  /**
   * Tests the size method at the boundaries and general cases
   */
  public void testSize() {
    //Test an empty Set
    assertEquals (empty.size(), 0);
    assertEquals (sixteen.size(), 0);
    
    //Test a minimal Set
    assertEquals (one.size(), 1);
    
    //Test any Set
    assertEquals (two.size(), 2);
    assertEquals (fifteen.size(), 15);
  }
  
  /**
   * Tests the newInstance method
   */
  public void testNewInstance() {
    assertTrue (fifteen.newInstance().isEmpty());
  }
  
  /**
   * Tests the copy method at the boundaries and the general case
   */
  public void testCopy() {
    //Test the empty Set
    assertTrue (empty.copy().toString().equals(empty.toString()));
    
    //Test the minimal Set
    assertTrue (one.copy().toString().equals(one.toString()));
    
    //Test larger Sets
    assertTrue (fifteen.copy().toString().equals(fifteen.toString()));
    assertTrue (two.copy().toString().equals(two.toString()));
  }
}
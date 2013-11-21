// ID:         2024458
// Class:      CSCI 2125-001
// Date:       9/30/2011
// Assignment: Homework 2 Part II

package CSCI_2125.Homework2ii;

import junit.framework.TestCase;

/**
 * A test class for Bag.
 */
public class BagTest extends TestCase {
  
  private LinkedBag<Integer> empty;
  private LinkedBag<Integer> one;
  private LinkedBag<Integer> manyOfOne;
  private LinkedBag<Integer> oneOfMany;
  private LinkedBag<Integer> manyOfMany;
  
  //Creates a variety of Bags to use in testing.
  protected void setUp () {
    empty = new LinkedBag<Integer> ();
    one = new LinkedBag<Integer> ();
    manyOfOne = new LinkedBag<Integer> ();
    oneOfMany = new LinkedBag<Integer> ();
    manyOfMany = new LinkedBag<Integer> ();
    
    //Used after testing of add (element, number)
    one.add (3, 1);
    manyOfOne.add (3, 15);
    
    for (int i = 0; i < 20; i = i + 2) {
      oneOfMany.add (i, 1);
      manyOfMany.add (i, 9);
    }
  }
  
  public void testIsEmpty () {
    assertTrue(empty.isEmpty());
    
    //Tests size of empty (more size tests throughout)
    assertEquals(empty.size(), 0);
  }
  
  
  /**
   * Tests the add method for each type of add.
   * Also tests isMember(), size() - iterator must work for isMember to work
   */
  public void testAdd () {
    
    //Test adding 0 of an element
    empty.add (6, 0);
    assertTrue (empty.isEmpty());
    
    //Test isMember (more isMember tests throughout)
    assertFalse (empty.isMember(6));
    
    empty.add (6, 1);
    //Test isMember with one element
    assertTrue (empty.isMember(6));
    //Test size with one element
    assertEquals (empty.size(), 1);
    
    empty.add (8, 3);
    //Test isMember with several elements
    assertTrue (empty.isMember(8));
    assertTrue (empty.isMember(6));
    //Test size with several elements (two different elements of different count)
    assertEquals (empty.size(), 4);
    
    //Test add with no quantity
    empty.add (6);  //add element already present (equivalent to add (6,1)
    assertEquals(empty.size(), 5);
    assertTrue (empty.isMember(6));
    //Test numberOf (tested more throughout subsequent testing)
    assertEquals (empty.numberOf(6), 2);
    empty.add (10);  //add new element
    assertEquals (empty.size(), 6);
    assertTrue (empty.isMember(10));
    assertFalse (empty.isEmpty());
    
  }
  
  /**
   * Test the toString method to use in further testing.  Also includes additional
   * testing of the add method (comparing with toString representation).
   */
  public void testToString () {
    //Test empty Bag
    assertTrue (empty.toString().equals("{}"));
    //Test one of one
    assertEquals (one.toString(), "{[3, 1]}");
    //Test many of one
    assertEquals (manyOfOne.toString(), "{[3, 15]}");
    //Test one of many
    assertEquals (oneOfMany.toString(), "{[0, 1], [2, 1], [4, 1], [6, 1], [8, 1]"
                    + ", [10, 1], [12, 1], [14, 1], [16, 1], [18, 1]}");
    //Test many of many
    assertEquals (manyOfMany.toString(), "{[0, 9], [2, 9], [4, 9], [6, 9], [8, 9]"
                    + ", [10, 9], [12, 9], [14, 9], [16, 9], [18, 9]}");
    
  }
  
  
  /**
   * Test the remove method at the boundary cases
   */
  public void testRemove () {
    
    //Remove from empty
    empty.remove(4);
    assertTrue (empty.isEmpty());
    assertTrue (empty.size() == 0);
    
    //Remove from one
    one.remove (6);  //element not present
    assertEquals (one.size(), 1);
    assertFalse (one.isMember(6));
    one.remove (3); //element present
    assertTrue (one.isEmpty());
    assertFalse (one.isMember(3));
    
    //Remove from many of one
    manyOfOne.remove(5);  //element not present
    assertEquals (manyOfOne.size(), 15);
    manyOfOne.remove(3);  //element present
    assertEquals (manyOfOne.size(), 14);
    assertTrue (manyOfOne.isMember(3));
    
    //Remove from one of many
    oneOfMany.remove(10);
    assertFalse (oneOfMany.isMember(10));
    assertEquals (oneOfMany.size(), 9);
    //Test remove in quantity at 0
    oneOfMany.remove(12, 0);
    assertTrue (oneOfMany.isMember(12));
    assertEquals (oneOfMany.size(), 9);
    //Test remove in quantity at 1
    oneOfMany.remove(12, 1);
    assertFalse (oneOfMany.isMember(12));
    
    //Remove from many of many
    manyOfMany.remove (10);
    assertTrue (manyOfMany.isMember(10));
    assertEquals (manyOfMany.size(), 89);
    //Test remove in quantity at many
    manyOfMany.remove (14, 6);
    assertEquals (manyOfMany.numberOf(14), 3);
    assertEquals (manyOfMany.size(), 83);
    assertTrue (manyOfMany.isMember(14));
    assertEquals (manyOfMany.toString(), "{[0, 9], [2, 9], [4, 9], [6, 9], [8, 9]"
                    + ", [10, 8], [12, 9], [14, 3], [16, 9], [18, 9]}");
    
    //Remove all from many
    manyOfMany.removeAll(4);
    assertFalse(manyOfMany.isMember(4));
    assertEquals (manyOfMany.size(), 74);
  }
  
  /**
   * Test emtpyBag
   */
  public void testEmptyBag() {
    
    //Empty an empty bag
    empty.emptyBag();
    assertTrue (empty.isEmpty());
    
    //Empty a bag of one
    one.emptyBag();
    assertTrue (one.isEmpty());
    
    //Empty one of many
    assertTrue (oneOfMany.isMember(12));
    assertEquals (oneOfMany.numberOf(12), 1);
    oneOfMany.emptyBag();
    assertTrue (oneOfMany.isEmpty());
    assertEquals (oneOfMany.numberOf(12), 0);
    
    //Empty many of one
    manyOfOne.emptyBag();
    assertTrue (manyOfOne.isEmpty());
    
    //Empty many of many
    assertTrue (manyOfMany.isMember(16));
    assertEquals (manyOfMany.numberOf(16), 9);
    manyOfMany.emptyBag();
    assertFalse (manyOfMany.isMember(16));
    assertEquals (manyOfMany.numberOf(16), 0);
    assertTrue (manyOfMany.isEmpty());
    assertEquals (manyOfMany.size(), 0);
    
  }
  
  /**
   * Tests the contains method at boundaries.  Empty bags contain other empty
   * bags.  Tests copy method as well.  Copies of bags contain the bag they were
   * copied from and bags contains copies of themselves.
   */
  public void testContains () {
    
    //Test empty contains
    assertFalse(empty.contains(one));
    assertTrue(empty.contains(empty.copy()));
    assertTrue(empty.copy().contains(empty));
    assertTrue(one.contains(empty));
    
    //Test one contains one
    assertFalse(empty.contains(one));
    empty.add (3);
    assertTrue (one.contains(empty));
    assertTrue (one.contains(one.copy()));
    assertTrue (one.copy().contains(one));
    
    //Test one contains many and many contains one
    empty.add (3);
    assertTrue (empty.contains(one));
    assertEquals (manyOfMany.contains(one), false);
    empty.remove (3, 2);
    empty.add (4, 1);
    assertTrue (oneOfMany.contains(empty));
    
    //Test many contains many
    assertFalse (oneOfMany.contains(manyOfMany));
    assertFalse (empty.contains(manyOfMany));
  }
  
  /**
   * Tests union of bags.  Also tests copy method (used in Union).
   */
  public void testUnion () {
    
    //Test union with empty
    assertEquals(empty.toString(), empty.union(empty).toString());
    assertEquals(one.toString(), one.union(empty).toString());
    assertEquals(oneOfMany.toString(), oneOfMany.union(empty).toString());
    
    //Test union one with one
    assertEquals(one.union(one).toString(), "{[3, 2]}");
    empty.add(5);
    assertEquals(one.union(empty).toString(), "{[3, 1], [5, 1]}");
    
    //Test union one with many
    assertEquals(manyOfOne.union(one).toString(), "{[3, 16]}");
    assertEquals(oneOfMany.union(one).toString(), "{[0, 1], [2, 1], [4, 1], " + 
                 "[6, 1], [8, 1], [10, 1], [12, 1], [14, 1], " + 
                 "[16, 1], [18, 1], [3, 1]}");
    
    //Test union many with many
    assertEquals(manyOfMany.union(manyOfOne).toString(), "{[0, 9], [2, 9], " +
                 "[4, 9], [6, 9], [8, 9], [10, 9], [12, 9], " +
                 "[14, 9], [16, 9], [18, 9], [3, 15]}");
    assertEquals(manyOfMany.union(oneOfMany).toString(), "{[0, 10], [2, 10], " +
                 "[4, 10], [6, 10], [8, 10], [10, 10], [12, 10], " +
                 "[14, 10], [16, 10], [18, 10]}");
  }
  
  /**
   * Tests intersection of bags.  Also tests newBag method (used in Intersection).
   */
  public void testIntersection () {
    
    //Test intersection with empty
    assertEquals(empty.intersection(one).toString(), "{}");
    assertEquals(one.intersection(empty).toString(), 
                 empty.intersection(one).toString());
    
    //Test intersection one with one
    empty.add(5);
    assertEquals(one.intersection(one).toString(), one.toString());
    assertEquals(one.intersection(empty).toString(), "{}");
    empty.add(3);
    assertEquals(one.intersection(empty).toString(), "{[3, 1]}");
    
    //Test intersection one with many
    assertEquals(one.intersection(manyOfOne).toString(), "{[3, 1]}");
    assertEquals(manyOfOne.intersection(one).toString(), "{[3, 1]}");
    assertEquals(one.intersection(oneOfMany).toString(), "{}");
    
    //Test intersection many with many
    assertEquals(oneOfMany.intersection(manyOfMany).toString(), 
                 "{[0, 1], [2, 1], [4, 1], [6, 1], [8, 1]"
                   + ", [10, 1], [12, 1], [14, 1], [16, 1], [18, 1]}");
  }
  
  /**
   * Tests difference between bags.
   */
  public void testDifference () {
    
    //Test difference with empty
    assertTrue(empty.difference(one).isEmpty());
    assertEquals(one.difference(empty).toString(), one.toString());
    
    //Test difference one with one
    assertEquals(one.difference(one).toString(), empty.toString());
    empty.add(5);
    assertEquals(one.difference(empty).toString(), "{[3, 1]}");
    assertEquals(empty.difference(one).toString(), "{[5, 1]}");
    
    //Test difference one with many
    assertTrue(one.difference(manyOfOne).isEmpty());
    assertEquals(manyOfOne.difference(one).toString(), "{[3, 14]}");
    
    //Test difference many with many
    assertTrue(oneOfMany.difference(manyOfMany).isEmpty());
    assertEquals(manyOfMany.difference(oneOfMany).toString(), "{[0, 8], " +
                 "[2, 8], [4, 8], [6, 8], [8, 8], [10, 8], " +
                 "[12, 8], [14, 8], [16, 8], [18, 8]}");
    assertEquals(manyOfOne.difference(manyOfMany).toString(), 
                 manyOfOne.toString());
    
  }
  
  /**
   * Tests uniqueEntries of a bag.  Also tests uniqueNumber.
   */
  public void testUniqueEntries () {
    
    //Test empty
    assertTrue(empty.uniqueEntries().isEmpty());
    assertEquals(empty.uniqueNumber(), 0);
    
    //Test one
    assertEquals(one.uniqueEntries().toString(), "{[3, 1]}");
    assertEquals(one.uniqueNumber(), 1);
    
    //Test one of many
    assertEquals(oneOfMany.uniqueEntries().toString(), oneOfMany.toString());
    assertEquals(oneOfMany.uniqueNumber(), 10);
    
    //Test many of one
    assertEquals(manyOfOne.uniqueEntries().toString(), one.toString());
    assertEquals(manyOfOne.uniqueNumber(), 1);
    
    //Test many of many
    assertEquals(manyOfMany.uniqueEntries().toString(), oneOfMany.toString());
    assertEquals(manyOfMany.uniqueNumber(), 10);
    
  }
  
  /**
   * Tests equals.  
   */
  public void testEquals () {
    
    //Test empty
    assertTrue(empty.equals(empty));
    assertFalse(empty.equals(one));
    
    //Test one and one
    assertFalse(one.equals(empty));
    empty.add(3);
    assertTrue(one.equals(empty));
    assertTrue(one.equals(one));
    
    //Test one and many
    assertFalse(one.equals(oneOfMany));
    assertFalse(one.equals(manyOfOne));
    
    //Test many and many
    assertFalse(manyOfOne.equals(manyOfMany));
    assertTrue(manyOfMany.uniqueEntries().equals(oneOfMany));
  }
  
  
}
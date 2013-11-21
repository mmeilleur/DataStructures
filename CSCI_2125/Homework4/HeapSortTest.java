// ID:         2024458
// Class:      CSCI 2125-001
// Date:       11/04/2011
// Assignment: Homework 4

package CSCI_2125.Homework4;

import junit.framework.TestCase;

/**
 * A test class for heapSort.
 */
public class HeapSortTest extends TestCase {
  
  private String[] stringsIncreasing;
  private String[] stringsAlmost;
  private String[] stringsRandom;
  private Integer[] ints1;
  private Integer[] ints2;
  private Integer[] intsDecreasing;
  //Generated with java.util.Random, for each i, random.nextInt(300)
  private Integer[] intsLarge = {14, 266, 135, 31, 74, 272, 165, 11, 263, 20, 275, 
    188, 265, 299, 175, 107, 83, 225, 298, 107, 236, 292, 153, 146, 82, 89, 110, 
    139, 93, 60, 79, 213, 6, 259, 249, 132, 110, 154, 286, 167, 98, 130, 243, 107, 
    56, 213, 152, 296, 207, 294, 169, 230, 25, 194, 106, 158, 77, 47, 265, 71, 229,
    105, 160, 132, 107, 291, 279, 224, 280, 179, 199, 233, 62, 2, 105, 193, 166, 
    78, 230, 143, 22, 203, 79, 155, 277, 214, 278, 90, 268, 209, 223, 113, 26, 96,
    9, 71, 96, 112, 233, 74, 27, 287, 222, 8, 225, 291, 140, 271, 58, 136, 295, 
    160, 87, 13, 135, 276, 12, 207, 40, 181, 28, 98, 52, 176, 243, 145, 30, 15, 
    187, 109, 112, 259, 288, 241, 109, 267, 13, 129, 240, 173, 217, 130, 137, 39,
    64, 54, 33, 22, 188, 285, 26, 107, 63, 91, 44, 145, 257, 44, 143, 159, 275, 63,
    146, 206, 63, 131, 293, 104, 24, 213, 53, 230, 2, 39, 173, 177, 248, 9, 205,
    180, 182, 39, 90, 12, 294, 43, 172, 212, 179, 145, 15, 239, 260, 273, 166, 261, 
    223, 40, 78, 63};
  private String intsLargeToString;
  private String intsLargeToStringSorted;
  private String stringsIncreasingSorted;
  private String stringsAlmostSorted;
  private String stringsRandomSorted;
  private IntegerComparator compInts;
  private StringComparator compStrings;
  
  protected void setUp () {
    //Initialize arrays
    stringsIncreasing = new String[3];
    stringsAlmost = new String[7];
    stringsRandom = new String[10];
    ints1 = new Integer[1];
    ints2 = new Integer[2];
    intsDecreasing = new Integer[5];
    //Comparators from Homework3 also packaged in Homework4
    compInts = new IntegerComparator();
    compStrings = new StringComparator();
    
    //Fill arrays
    stringsIncreasing[0] = "Apple";
    stringsIncreasing[1] = "Banana";
    stringsIncreasing[2] = "Pear";
    stringsIncreasingSorted = "[Pear, Banana, Apple]";
    
    stringsAlmost[0] = "Angel";
    stringsAlmost[1] = "Basket";
    stringsAlmost[2] = "Devil's Food";
    stringsAlmost[3] = "Heavenly";
    stringsAlmost[4] = "Enter";
    stringsAlmost[5] = "Psalm";
    stringsAlmost[6] = "Vanilla";
    stringsAlmostSorted = "[Vanilla, Psalm, Heavenly, Enter, Devil's Food, " +
      "Basket, Angel]";
    
    stringsRandom[0] = "Memory";
    stringsRandom[1] = "Metaphor";
    stringsRandom[2] = "Simile";
    stringsRandom[3] = "Alliteration";
    stringsRandom[4] = "Conjugate";
    stringsRandom[5] = "Literature";
    stringsRandom[6] = "Volumes";
    stringsRandom[7] = "Diction";
    stringsRandom[8] = "Candleabra";
    stringsRandom[9] = "Heap";
    stringsRandomSorted = "[Volumes, Simile, Metaphor, Memory, Literature, " +
      "Heap, Diction, Conjugate, Candleabra, Alliteration]";
    
    ints1[0] = 42;
    
    ints2[0] = 18;
    ints2[1] = 18;
    
    for (int i = 0; i < intsDecreasing.length; i = i + 1) {
      intsDecreasing[i] = 10 - i*2;
    }
    
    intsLargeToString = "[14, 266, 135, 31, 74, 272, 165, 11, 263, 20, 275, " + 
      "188, 265, 299, 175, 107, 83, 225, 298, 107, 236, 292, 153, 146, 82, 89, " +
      "110, 139, 93, 60, 79, 213, 6, 259, 249, 132, 110, 154, 286, 167, 98, 130," +
      " 243, 107, 56, 213, 152, 296, 207, 294, 169, 230, 25, 194, 106, 158, 77, " +
      "47, 265, 71, 229, 105, 160, 132, 107, 291, 279, 224, 280, 179, 199, 233, " +
      "62, 2, 105, 193, 166, 78, 230, 143, 22, 203, 79, 155, 277, 214, 278, 90, " +
      "268, 209, 223, 113, 26, 96, 9, 71, 96, 112, 233, 74, 27, 287, 222, 8, " +
      "225, 291, 140, 271, 58, 136, 295, 160, 87, 13, 135, 276, 12, 207, 40, " +
      "181, 28, 98, 52, 176, 243, 145, 30, 15, 187, 109, 112, 259, 288, 241, " +
      "109, 267, 13, 129, 240, 173, 217, 130, 137, 39, 64, 54, 33, 22, 188, " +
      "285, 26, 107, 63, 91, 44, 145, 257, 44, 143, 159, 275, 63, 146, 206, 63, " +
      "131, 293, 104, 24, 213, 53, 230, 2, 39, 173, 177, 248, 9, 205, 180, 182, " +
      "39, 90, 12, 294, 43, 172, 212, 179, 145, 15, 239, 260, 273, 166, 261, " +
      "223, 40, 78, 63]";
    
    intsLargeToStringSorted = "[299, 298, 296, 295, 294, 294, 293, 292, 291, 291, "
      + "288, 287, 286, 285, 280, 279, 278, 277, 276, 275, 275, 273, 272, 271, "
      + "268, 267, 266, 265, 265, 263, 261, 260, 259, 259, 257, 249, 248, 243, "
      + "243, 241, 240, 239, 236, 233, 233, 230, 230, 230, 229, 225, 225, 224, "
      + "223, 223, 222, 217, 214, 213, 213, 213, 212, 209, 207, 207, 206, 205, "
      + "203, 199, 194, 193, 188, 188, 187, 182, 181, 180, 179, 179, 177, 176, "
      + "175, 173, 173, 172, 169, 167, 166, 166, 165, 160, 160, 159, 158, 155, "
      + "154, 153, 152, 146, 146, 145, 145, 145, 143, 143, 140, 139, 137, 136, "
      + "135, 135, 132, 132, 131, 130, 130, 129, 113, 112, 112, 110, 110, 109, "
      + "109, 107, 107, 107, 107, 107, 106, 105, 105, 104, 98, 98, 96, 96, 93, "
      + "91, 90, 90, 89, 87, 83, 82, 79, 79, 78, 78, 77, 74, 74, 71, 71, 64, 63, "
      + "63, 63, 63, 62, 60, 58, 56, 54, 53, 52, 47, 44, 44, 43, 40, 40, 39, 39, "
      + "39, 33, 31, 30, 28, 27, 26, 26, 25, 24, 22, 22, 20, 15, 15, 14, 13, 13, "
      + "12, 12, 11, 9, 9, 8, 6, 2, 2]";
    
  }
  
  /**
   * Test arrays of small size, and an array that contains the only same element
   */
  public void testSmallSort () {
    //Initial state
    assertEquals(java.util.Arrays.toString(ints1), "[42]");
    assertEquals(java.util.Arrays.toString(ints2), "[18, 18]");
    assertEquals(java.util.Arrays.toString(stringsIncreasing), 
                 "[Apple, Banana, Pear]");
    HeapSorter.heapSort(ints1, 1, compInts); //length 1
    HeapSorter.heapSort(ints2, 2, compInts); //length 2
    HeapSorter.heapSort(stringsIncreasing, 3, compStrings); //length 3, string
    //After sort
    assertEquals(java.util.Arrays.toString(ints1), "[42]");
    assertEquals(java.util.Arrays.toString(ints2), "[18, 18]");
    assertEquals(java.util.Arrays.toString(stringsIncreasing), 
                 stringsIncreasingSorted);
  }
  
  /**
   * Test various string arrays
   */
  public void testStringSorts () {
    //Initial state
    assertEquals(java.util.Arrays.toString(stringsAlmost), "[Angel, Basket, " +
                 "Devil's Food, Heavenly, Enter, Psalm, Vanilla]");
    assertEquals(java.util.Arrays.toString(stringsRandom), "[Memory, Metaphor, "
                   + "Simile, Alliteration, Conjugate, Literature, Volumes, " 
                   + "Diction, Candleabra, Heap]");
    HeapSorter.heapSort(stringsAlmost, 7, compStrings); //almost order, odd, string
    HeapSorter.heapSort(stringsRandom, 10, compStrings); //random order, even, str
    //After sort
    assertEquals(java.util.Arrays.toString(stringsAlmost), stringsAlmostSorted);
    assertEquals(java.util.Arrays.toString(stringsRandom), stringsRandomSorted);
  }
  
  /**
   * Test already ordered array
   */
  public void testDecreasingOrder () {
    //Initial state
    assertEquals(java.util.Arrays.toString(intsDecreasing), "[10, 8, 6, 4, 2]");
    HeapSorter.heapSort(intsDecreasing, 5, compInts); //decreasing order, odd
    //After sort
    assertEquals(java.util.Arrays.toString(intsDecreasing), 
                 java.util.Arrays.toString(intsDecreasing));
  }
  
  /**
   * Test relatively large array
   */
  public void testLargeSort () {
    //Initial state
    assertEquals(java.util.Arrays.toString(intsLarge), intsLargeToString);
    HeapSorter.heapSort(intsLarge, 200, compInts); //large, even, ints, unsorted
    assertEquals(java.util.Arrays.toString(intsLarge), intsLargeToStringSorted);
  }
  
}
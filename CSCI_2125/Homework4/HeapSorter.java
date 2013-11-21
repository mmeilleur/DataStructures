// ID:         2024458
// Class:      CSCI 2125-001
// Date:       11/04/2011
// Assignment: Homework 4

package CSCI_2125.Homework4;

import java.util.Comparator;

/**
 * A simple class to collect HeapSort methods.
 */
public class HeapSorter {
  
  /**
   * Sorts a given array using heapSort.
   * 
   * @require     table != null && size =! null && size >= 0
   *              && order != null
   * 
   * @ensure      Elements in table will be sorted in descending order based on
   *              order
   */
  public static <T> void heapSort(T[] table, int size, Comparator<T> order){
    
    buildHeap(table, size, order);
    for (int i = size - 1; i > 0; i = i - 1) {
      //swap top with i entry
      swap(table, 0, i);
      heapify(table, 0, i, order);
    }
  }
  
  /**
   * Rearranges the subtree at the provided i into a heap.
   * 
   * @require     table != null && i >= 0 && size >= 0 && order != null
   *              table has no null entries between 0 and size
   *
   * @ensure      The given element will be in a position such that any existing
   *              children are greater than or equal to it, based on order
   */
  private static <T> void heapify(T[] table, int i, int size, Comparator<T> order) {
    int temp = getSmallestChild(table, i, size, order);
    //moves element down if necessary and heapifies at the new index
    if (temp != i) {
      swap(table, i, temp);
      heapify(table, temp, size, order);
    }
  }
  
  /**
   * A private helper method for heapify - find the index of the smallest of the
   * given element and any of its children.
   * 
   * @require     table != null && i >= 0 && size >= 0 && order != null
   * 
   * @ensure      Returns the smallest of i and any existing children,  based on  
   *              order.  If no children exist, returns i.
   */
  private static <T> int getSmallestChild (T[] table, int i, int size, 
                                           Comparator<T> order) {
    int minIndex = i;
    //First case - both children exist
    if (leftChildExists(i, size) && rightChildExists(i, size)) {
      int minChild = getMin(table, 2*i + 1, 2*i + 2, order); //Finds smallest child
      //Compares smallest child to parent
      minIndex = getMin(table, i, minChild, order); 
    }
    //Second case - only one child exists
    else if (leftChildExists(i, size))
      //Compares smallest child to parent
      minIndex = getMin(table, i, 2*i + 1, order);
    //minIndex = i if no children
    return minIndex;
  }
  
  /**
   * A private helper method for getSmallestChild - checks for the existence of
   * a left child.
   * 
   * @require     i != null && size != null
   * 
   * @ensure      Returns true if the index of a left child < size
   */
  private static boolean leftChildExists (int i, int size) {
    return ((2*i + 1) < size);
  }
  
  /**
   * A private helper method for getSmallestChild - checks for the existence of
   * a right child.
   * 
   * @require     i != null && size != null
   * 
   * @ensure      Returns true if the index of a right child < size
   */
  private static boolean rightChildExists (int i, int size) {
    return ((2*i + 2) < size);
  }
  
  /**
   * A private helper method for getSmallestChild - returns the index of the
   * smaller of the elements at two given indices.
   * 
   * @require     table != null && first >= 0 && second >= 0 && order != null
   * 
   * @ensure      If order.compare(table[first], table[second]) <= 0, returns first
   *              else returns second
   */
  private static <T> int getMin (T[] table, int first, int second, 
                                 Comparator<T> order) {
    int minIndex = first;
    if (order.compare(table[first], table[second]) >= 0) //if second element < first
      minIndex = second;
    return minIndex;
  }
  
  /**
   * Rearranges the given array into a heap.
   * 
   * @require     table != null && size >= 0 && order != null
   * 
   * @ensure      Each element in table will have the property:
   *              Every existing child >= its parent, based on order
   */
  private static <T> void buildHeap(T[] table, int size, Comparator<T> order) {
    //heapify every element in table, starting from the last
    for (int i = size - 1; i >= 0; i = i - 1) {
      heapify(table, i, size, order);
    }
  }
  
  /**
   * Swaps two entries in an array based on provided indices.
   * 
   * @require     table != null && swapToEntry < table.length 
   *              && swapFromEntry < table.length
   * 
   * @ensure      table[swapToEntry] == table[swapFromEntry] && 
   *              table[swapFromEntry] == table[swapToEntry]
   */
  private static <T> void swap (T[] table, int swapToEntry, int swapFromEntry) {
    T temp = table[swapFromEntry]; //temporarily store from
    table[swapFromEntry] = table[swapToEntry]; //overwrite from with to
    table[swapToEntry] = temp; //move temp to to
  }
  
}
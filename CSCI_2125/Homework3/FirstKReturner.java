// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import java.util.Comparator;

public class FirstKReturner<Element extends Comparable<? super Element>> {
  
  private LinkedPriorityQueue<Element> list;
  
  public FirstKReturner (Comparator<Element> order) {
    list = new LinkedPriorityQueue<Element> (order);
  }
  
}
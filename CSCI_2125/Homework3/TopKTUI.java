// ID:         2024458
// Class:      CSCI 2125-001
// Date:       10/24/2011
// Assignment: Homework 3

package CSCI_2125.Homework3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;

/**
 * A user interface for retrieving the first k elements in a PriorityQueue.
 */
public class TopKTUI {
  
  private Scanner in;
  private LinkedPriorityQueue data;
  private LinkedPriorityQueue copy;
  private LinkedPriorityQueue results;
  
  public TopKTUI () {    
    in = new Scanner (System.in);
  }
  
  /**
   * Displays the menu.
   */
  private void displayMenu() {
    
    System.out.println("\nWhat kind of data would you like to input?\r");
    System.out.println("\nPlease select from the following options:");
    System.out.println("               For integers, enter 1.");
    System.out.println("                For strings, enter 2.");
    System.out.println("                    To exit, enter 0.");
    
  }
  
  /**
   * Prints the given prompt and returns the choice entered by the user.
   */
  private int getChoice (String prompt) {
    int result = -1;
    boolean reprompt = true;
    
    //Prompts user for a valid input.  Will reprompt until input is valid.
    while (reprompt) {
      System.out.print(prompt);
      if (in.hasNextInt()) {
        result = in.nextInt();
        reprompt = false;
      }
      else {
        System.out.println("Please make a valid selection.");
      }
    }
    return result;
  }
  
  /**
   * Gets the required information from the user regarding the file they would
   * like to import data from.
   */
  private Scanner getFile () {
    boolean again = true;
    Scanner input = null;
    //Prompts the user for a valid file location.
    while (again) {
      System.out.println("Please enter the location of the file you would like" + 
                         " to use.");
      String filename = in.next();
      File data = new File(filename);
      try {        
        input = new Scanner (data);
        again = false;
      }
      catch (FileNotFoundException e) {
        System.out.println("That file was not found.  Please try again.");
      }
    }
    return input;
  }
  
  /**
   * Performs the user's choice based on their selection of data type.
   * 
   * @require     0 <= choice <= 2
   */
  private void performChoice (int choice) {
    if (choice == 1) {
      data = new LinkedPriorityQueue<Integer> (new IntegerComparator());
      this.readIntsFile(this.getFile());
      results = new LinkedPriorityQueue<Integer> (new IntegerComparator());
      returnKValues();
    }
    else if (choice == 2) {
      data = new LinkedPriorityQueue<String> (new StringComparator());
      this.readStringFile(this.getFile());
      results = new LinkedPriorityQueue<String> (new StringComparator());
      returnKValues();
    }
    else if (choice == 0)
      System.out.println("Thank you.  Goodbye!");
    
    else
      System.out.println("Please enter an integer between 0 and 2.");
  }
  
  /**
   * Requests a k from the user to return from the PriorityQueue and returns
   * that many values from the data.
   */
  private void returnKValues () {    
    boolean again = true;
    //Continues asking for a new k until the user indicates not to
    while (again) {
      results.clear();
      copy = data.copy();
      int k = getChoice ("How many of the top values would you like returned?");
      if (k > data.size())
        k = data.size();
      //Adds k top values to results
      for (int i = 0; i < k; i = i + 1) {
        results.enqueue(copy.highest()); //unchecked call: checked - results and
                                         //copy can only contain the same type   
        copy.serve();
      }
      System.out.println(results.toString() + "\r\n");
      System.out.println("Would you like a different number of top values?");
      System.out.println("Enter Y for yes or N for no.");
      if (in.next().toLowerCase().equals("n"))
        again = false;
    }
  }
  
  /**
   * Adds strings to the priority queue
   */
  private void readStringFile (Scanner input) {
    //Adds string to the data until there are no more tokens
    while(input.hasNext()) 
      data.enqueue(input.next());    //unchecked call: checked - method is only
                                     //called when the data is of type String
  }
  
  /**
   * Adds integers to the priority queue
   */
  private void readIntsFile (Scanner input) {
    //Adds integers to the data until there are no more tokens
    while (input.hasNextInt())
      data.enqueue(input.nextInt()); //unchecked call: checked - method is only
                                     //called when the data is of type Integer
  }
  
  public void start () {
    int choice = -1;
    //Keeps the TUI active until the user chooses to quit
    while (choice != 0) {
      displayMenu();
      choice = getChoice("Please make your selection: ");      
      performChoice(choice);
    }
  }
  
  /**
   * The main method which allows the TUI to be run.
   */
  public static void main(String[] args) {
    TopKTUI tui = new TopKTUI();
    tui.start();
  }
  
}
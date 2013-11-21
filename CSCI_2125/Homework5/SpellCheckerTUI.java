// ID:         2024458
// Class:      CSCI 2125-001
// Date:       12/2/2011
// Assignment: Homework 5

package CSCI_2125.Homework5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheckerTUI {
  
  private HashTable<String, Object> dictionary;
  private Scanner input;
  private File file;
  private LinkedSet<String> misspelled;
  
  /**
   * The main method of the TUI that allows the program to run.
   */
  public static void main (String[] argv) {
    SpellCheckerTUI tui = new SpellCheckerTUI();
    tui.start();    
  }
  
  
  /**
   * Constructor for the TUI - it initialized and loads the dictionary.
   */
  public SpellCheckerTUI () {
    dictionary = new HashTable<String, Object> (88984);
    File dict = new File ("C:\\Users\\Sayobel\\Documents\\School Files" +
                          "\\CSCI_2125\\Homework5\\dict.txt");
    try {
      Scanner addDictionary = new Scanner (dict);
      //Loops through the contents of the dict file
      while (addDictionary.hasNext()) {
        dictionary.add(addDictionary.next(), null);
      }
      addDictionary.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("Error in dictionary file.");
    }
    input = new Scanner (System.in);
    misspelled = new LinkedSet<String>();
  }
  
  
  /**
   * Displays the menu to the user
   */
  public void displayMenu () {
    System.out.println("\nPlease select from the following options: ");
    System.out.println("To spellcheck a file, enter 1. ");
    System.out.println("To exit the program,  enter 2. ");    
  }
  
  
  /**
   * Compares each word in the file provided by the user to the dictionary.
   */
  public void checkFile () {    
    System.out.println ("Please enter a file to spellcheck: ");
    String filename = new Scanner(System.in).next();
    file = new File (filename);
    try {
      Scanner check = new Scanner (file);
      
      //Empties the Set for each file scanned.
      if (!misspelled.isEmpty())
        misspelled = misspelled.newInstance();
      check.useDelimiter("\\b"); //ignores punctuation
      
      //Loops through provided file's tokens, checking dictionary
      while (check.hasNext()) {
        String current = check.next();
        current = current.trim();
        if (current.length() > 2) {
          if (!dictionary.contains(current.toLowerCase()))
            misspelled.add(current);
        }
      }
      
      //If there are no misspelled words
      if (misspelled.isEmpty())
        System.out.println("\nThere are no misspelled words in your file.\n");
      
      //Some words did not match the dictionary
      else {
        System.out.println("\nThe following words may be misspelled: \n");
        System.out.println(misspelled.toString());
      }
      check.close();
    }
    catch (FileNotFoundException e) {
      System.err.println("That file was not found.");
    }    
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
      if (input.hasNextInt()) {
        result = input.nextInt();
        reprompt = false;
      }
      else {
        System.out.println("Please make a valid selection.");
      }
    }
    return result;
  }
  
  
  /**
   * Performs the user's choice based on their selection of data type.   * 
   * @require     0 < choice <= 2
   */
  private void performChoice (int choice) {
    if (choice == 1) {
      checkFile();      
    }
    else if (choice == 2) {
      System.out.println("Thank you.  Goodbye!");
      input.close();
    }   
    else
      System.out.println("Please enter 1 or 2.");
  }
  
  
  /**
   * Starts the TUI and maintains its function until the user chooses
   * to quit the application.
   */
  public void start () {
    int choice = 0;
    
    //Keeps the TUI active until the user chooses to quit
    while (choice != 2) {
      displayMenu();
      choice = getChoice("Please make your selection: ");      
      performChoice(choice);
    }
  }    
}
//package hw3_CSCI_2125;
import java.util.Scanner;
import java.io.*;
import nhUtilities.containers2.*;


/**
 * 2127050
 * HW3 Part-2 CSCI_2125
 * due 11/09/12
 */

public class WordGameTUI {

  public static void main (String args[]) {
    
    (new WordGameTUI()).start();
    
  }
  // instance variables for the menu
  
  private final int NO_CHOICE = -1;
  private final int QUIT = 0;
  private final int ENTER_GUESS = 1;
  private WordFinderGame game;
  private Set<String> guesses;
  
  // method to run the TUI
  
  public void start() {
    game = new WordFinderGame();
    guesses = new LinkedSet<String>();
    int option = -1;
    
    // while loop to show the menu options
    
    while (option != 0) {
      showMenu();
      option = readIntWithPrompt("Enter option from Menu: ");
      performChoice(option);
      
    } // end of while loop
  } // end of start method
  
  // method to show menu
private void showMenu() {
  
  System.out.println("\r\nYour word is: " + game.currentWord());
  System.out.println("Current Score: " + guesses.size()*10);
    System.out.println("\r\nMENU: ");    
    System.out.println("Quit Program ............" + QUIT); 
    System.out.println("Guess a Word ............" + ENTER_GUESS); 
    
  }
  
  // method to read the integer from the prompt
  
  private int readIntWithPrompt(String prompt) {
    
    Scanner scanner = new Scanner(System.in);
    
    // while loop that implements scanner to read the next prompt  
    while (!scanner.hasNextInt()) {
      
      scanner.nextLine();
      System.out.print(prompt);
      System.out.flush();
      
    }
    int input = scanner.nextInt();  
    scanner.nextLine();
    
    return input;
    
  } // end of readIntWithPrompt method 
  
// method to perform the option selected by user
  private void performChoice(int option) {
    
    // quits the program
    if (option == 0) {
      
      System.out.println("You are now quitting the WordFinderGame Program.");
      showMenu();
      
    } // guesses the word
    else if (option == 1) {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter your guess: ");
      String guess = in.next();
      if(guess.length() < 4)
        System.out.println("That's not long enough.");
      else if(guesses.contains(guess)) {
        System.out.println("You already guessed that.");
      }
      else if(game.guessWord(guess)) {
        guesses.add(guess);
        System.out.println("Good guess!");
      }
      else
        System.out.println("That isn't a good guess.");
    }
    else { // otherwise invalid option message is showed
      
      System.out.println("Invalid option. Please select from MENU options.");
      showMenu();
      
    }
  }
  
  
}
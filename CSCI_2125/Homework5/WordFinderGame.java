import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import nhUtilities.containers2.*;

public class WordFinderGame {
  
  private static final Object DUMMY = new Object();
  private HashTable<String, Object> wordList;
  private Set<String> guesses;
  private String word;
  
  public WordFinderGame() {
    this.wordList = new HashTable<String, Object>(88984);
    File fileName = new File("C:\\Users\\Sayobel\\Documents\\School Files" +
                          "\\CSCI_2125\\Homework5\\dict.txt");
    try{
    Scanner in = new Scanner(fileName);
    while(in.hasNext()) {
      wordList.add(in.next(), null);
    }
    in.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("File Not Found: " + fileName);
    }
    this.guesses = new LinkedSet<String>();
    this.word = getRandomWord();
  }
  
  public String getRandomWord() {
    Random random = new Random();
    String word = "";
    Iterator<String> iter = wordList.keys().iterator();
    for (int i = 0; i < random.nextInt(wordList.keys().size()); i = i + 1)
      iter.advance();
    while (iter.get().length() < 5 && !iter.done()) {
      iter.advance();
      if(iter.done())
        iter.reset();
    }
    word = iter.get();
    return word;
  }
  
  public boolean guessWord(String guess) {
    boolean result = false;
    if(wordList.get(guess) != null) {
      Bag<Character> wordBag = new LinkedBag<Character>();
      for(int i = 0; i < this.word.length(); i = i + 1)
        wordBag.add(this.word.charAt(i));
      Bag<Character> guessBag = new LinkedBag<Character>();
      for(int i = 0; i < guess.length(); i = i + 1)
        guessBag.add(guess.charAt(i));
      if(guessBag.isContainedIn(wordBag))
        result = true;
    }
    return result;
  }
  
  public String currentWord() {
    return this.word;
  }
  
  
}
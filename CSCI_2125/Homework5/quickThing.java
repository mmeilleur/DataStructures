import java.util.*;
import java.io.*;

public class quickThing {
  
  
  public static void main(String[] argv) {
    
    File file = new File ("C:\\Users\\Sayobel\\Documents\\School Files\\CSCI_2125\\Homework5\\dict.txt");
    try {
      Scanner in = new Scanner(file);
      int count = 0;
      while (in.hasNextLine()) {
        count = count + 1;
        in.nextLine();
      }
      System.out.println(count);
    }
    catch (Exception e) {
      System.out.println("Error");
    }
    
  }
  
}
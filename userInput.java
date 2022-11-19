import java.io.*;
import java.util.Scanner;

public class userInput {
  static String absolutePath = "";

  public static void main(String args[]) {

    verifyFile("studentData");
    verifyFile("response");
    verifyFile("answer");
    verifyFile("question");
  }
  public static String verifyFile(String fileType) {
    Scanner input = new Scanner(System.in);
    Boolean fileFound = false;
    while (true) {
      if (fileFound) {
        System.out.println("FILE FOUND! ");
        break;
      } 
      else {
        String fileName = "";
        System.out.print("Please enter " + fileType + " filename: ");
        fileName = input.nextLine();
        String pathName = System.getProperty("user.dir");
        fileFound = searchDir(pathName, fileName);
      }
    }
    input.close();
    return userInput.absolutePath;
  }
  public static Boolean searchDir(String pathName, String fileName) {
    File path = new File(pathName);
    for (File file : path.listFiles()) {
      if (file.isDirectory()) {
        if (searchDir(file.getAbsolutePath(), fileName)) {
          return true;
        }
      } else {
        if (file.getName().equals(fileName)) {
          userInput.absolutePath = file.getAbsolutePath();
          return true;
        }
      }
    }
    return false;
  }
  
}

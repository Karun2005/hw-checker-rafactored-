import java.io.*;
import java.util.Scanner;

public class UserInput {
  static String absolutePath = "";
  
  /*
  *asks, receives and validates files entered by user
  */
  public static void main(String args[]) {

    verifyFile("studentData");
    verifyFile("response");
    verifyFile("answer");
    verifyFile("question");
  }
  /*
  *based on if file exists, or not.
  *it's either going to prompt the user to reenter another file name
  *or validate the file and return the file path
  *@param which type of file it is prompting the user to enter (studentData_response, answer)
  *@return String the filepath of a valid file
  */
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
    return absolutePath;
  }
  /*
  *searches through all the files. 
  *Determines if what it's searching is a directory of file
  *If directory, it will recursively enter and check files/other directories within it, until it recheas the level of a file
  *compare the file enter by user to every single file
  *@param pathName, the user's working directory 
  *@param fileName, the file entered by the user
  *@return boolean, true if file exists, false if not
  */
  public static Boolean searchDir(String pathName, String fileName) {
    File path = new File(pathName);
    for (File file : path.listFiles()) {
      if (file.isDirectory()) {
        if (searchDir(file.getAbsolutePath(), fileName)) {
          return true;
        }
      } else {
        if (file.getName().equals(fileName)) {
          absolutePath = file.getAbsolutePath();
          return true;
        }
      }
    }
    return false;
  }
  
}

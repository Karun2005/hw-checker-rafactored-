import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
class DataMethods{
    
    static String absolutePath = "";
    static Scanner reader = new Scanner(System.in);
  
    /**
     * Verifies if a file is on the users computer
     * @param fileType The type of file
     * @return The absolute path of the file
     */
    protected String verifyFile(String fileType) {
        boolean fileFound = false;
        int count = 0;
        while (true) {
          if (fileFound) {
            System.out.println("FILE FOUND! ");
            break;
          } 
          else {
            if(count>0){
              System.out.println();
              System.out.println("Invalid file!");
            }
            count++;
            String fileName = "";
            System.out.print("Please enter " + fileType + " filename: ");
            fileName = reader.nextLine();
            String pathName = System.getProperty("user.dir");
            fileFound = searchDir(pathName, fileName);
          }
        }
        return absolutePath;
      }
      /**
       * Recursively searches directories for a file
       * @param pathName Name of the file path
       * @param fileName Name of the file
       * @return Boolean based on if the file is found
       */
      protected Boolean searchDir(String pathName, String fileName) {
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
      /**
       * Reads a csv into a 2D array
       * @param filePath String containing the file path
       * @param amountOfFields The number of columns
       * @return 2D Array with the contents of the csv file
       */
    protected String[][] fileTo2DArray(String filePath, int amountOfFields){
        ArrayList<String> recordsList = new ArrayList <String>();

        //String delimiter = ",";
        String currentLine;

        try{
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while((currentLine = br.readLine()) != null){
            recordsList.add(currentLine);
        }

        int recordCount = recordsList.size();

        String arrayToReturn [][] = new String[recordCount][amountOfFields];

        Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
        while(sc.hasNextLine()) {
            for (int i=0; i<arrayToReturn.length; i++) {
                String[] line = sc.nextLine().trim().split(","); // Splits the string by seperating them by the delimiter 
                for (int j=0; j<line.length; j++) {
                arrayToReturn[i][j] = line[j];
                }
            }
        }
        br.close();
        return arrayToReturn;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    /**
     * Gets the numbers of columns in a csv file
     * @param filePath String containing the file path
     * @return int containing the number of columns
     */
    protected int getFileColumnsNumber(String filePath) {
    File file = new File(filePath);
    Scanner scanner;
    try {
        scanner = new Scanner(file);
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
        return -1;
    }
    int number = 0;
    if (scanner.hasNextLine()) {
        number = scanner.nextLine().split(",").length; // It counts the number of columns by separating the strings after the comma and then counting the number of strings
    }
    scanner.close();
    return number;
    }
    /**
     * Reads the answers file into an array
     * @param filepath String containing the file path
     * @return array conatining answers
     */
    protected String[] answersToArray(String filepath){
        ArrayList<String> recordsList = new ArrayList<String>();
    
        String currentLine;
    
        try{
          FileReader fr = new FileReader(filepath);
          BufferedReader br = new BufferedReader(fr);
    
          // Counts the number of questions
          while((currentLine = br.readLine()) != null){
            br.readLine();
            recordsList.add(currentLine);
            br.readLine();
          }
          br.close();
    
          // Stores the amount of questions (size of the array) into a variable
          int recordCount = recordsList.size();
    
          // Creates a 1D array containing all the answers from the answer key  
          String arrayToReturn [] = new String[recordCount];
    
    
          // Adds all the answers into the 1D array
          BufferedReader br2 = null;
          br2 = new BufferedReader(new FileReader(filepath));
          String contentLine;
          for (int i = 0; i < recordCount; i++) { 
            br2.readLine(); // It skips the heading (Q1, etc)
            contentLine = br2.readLine();
            arrayToReturn[i] = contentLine; 
            br2.readLine(); // It skips the blank string in between questions
          }
          br2.close();
          // Returns the array
          return arrayToReturn;
        }
        catch(Exception e){
          System.out.println(e);
          return null;
        }
      }
      /**
       * Marks the students responses
       * @param responseArr Array containing student responses
       * @param ansArr Array containing the answers
       * @return 2D Array containing the final marks
       */
      protected String[][] compareResponseToAnswerKey(String [][] responseArr, String [] ansArr){

        int lengthOfStudentResponses = responseArr.length;
        int lengthOfAnswers = ansArr.length;
    
        String[][] studentResponseIn2DArray = new String[lengthOfStudentResponses][5]; // Row is the length of the 2D array that contains the students' responses. Column is 5 because that is where the answer to questions start
        
        // Adds the answers from the response 2D array to the studentResponseIn2DArray 2D array
        for(int i = 0; i < lengthOfStudentResponses; i++) {
          for(int j = 0; j < 4; j++) {
            studentResponseIn2DArray[i][j] = responseArr[i][j]; 
          }
        }
    
        // Comparing the responses to the answer key 
        for(int i = 0; i < lengthOfStudentResponses; i++) { // Goes by rows
          int grade = 0;
          for(int j = 0; j < lengthOfAnswers; j++) { // Goes by column
            if(ansArr[j].equals(responseArr[i][j+4])) {
              grade = grade+1; // "grade" restes after every question is checked
            }
          }
          studentResponseIn2DArray[i][4] = String.valueOf(grade); // Stores the string grade into the array
        }
    
        return studentResponseIn2DArray; // Returns the new array. It has the same data, but now has the total grade in a new column
      }
      /**
       * Exports the final marks
       * @param arr Array containing the final marks
       * @param lengthOfAns int containing the number of answers
       */
      protected void finalGrade(String[][] arr, int lengthOfAns) {
        String fileName = "StudentFinalGrade.csv";
        try {
          File file = new File(fileName);
          FileWriter gradeFile = new FileWriter(file);
          for(int x = 0; x < arr.length;x++) {
            gradeFile.write(String.join(",",arr[x]) + "/" + lengthOfAns + "\n");
            //Combines the row of the new 2D array into one line in the new File
          }
          gradeFile.close();
        } 
        catch (IOException e) {
          System.out.println("Error");
          e.printStackTrace();
        }
        System.out.println("Finished Grading \nCheck " + fileName + " to see the results");
      }
}

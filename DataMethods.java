import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
class DataMethods{
    // Methods
    /**
     * Adds all the student responses into a 2D array
     * @param filepath the name of the file
     * @return number the number of columns
     * @throws Exception e;
     */
    public static String[][] ReadFileInto2DArray(String filepath, int amountOfFields){
        // First uses a Array List to find the number of rows
        ArrayList<String> recordsList = new ArrayList <String>();

        String currentLine;

        try{
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);

        while((currentLine = br.readLine()) != null){
            recordsList.add(currentLine);
        }
        br.close();
            
        // Stores the length(row) of the response file into a int variable 
        int recordCount = recordsList.size();

        // Creates the two 2D array
        String arrayToReturn [][] = new String[recordCount][amountOfFields];

        Scanner sc = new Scanner(new BufferedReader(new FileReader(filepath)));
        while(sc.hasNextLine()) {
            for (int i=0; i<arrayToReturn.length; i++) {
                String[] line = sc.nextLine().trim().split(","); // Splits the string by seperating them by the delimiter 
                for (int j=0; j<line.length; j++) {
                arrayToReturn[i][j] = line[j];
                }
            }
        }
        return arrayToReturn; // Returns the array
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
  /**
   * Finds the number of columns in a file
   * @param filename the name of the file
   * @return number the number of columns
   * @throws FileNotFoundException e;
   */
    public static int getFileColumnsNumber(String filename) {
        File file = new File(filename);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        int number = 0;
        if (scanner.hasNextLine()){
            number = scanner.nextLine().split(",").length; // It counts the number of columns by separating the strings after the comma and then counting the number of strings}
        }
        scanner.close();
        return number;
    }
    
  /**
   * Adds all the answers from the answer key file into a 1D array
   * @param filepath the name of the file
   * @return arrayToReturn the 1D array
   * @throws Exception e;
   */
  public static String[] oneDArray(String filepath){
    List<String> recordsList = new ArrayList <String>();

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

      // Returns the array
      return arrayToReturn;
    }
    catch(Exception e){
      System.out.println(e);
      return null;
    }
  }
    
  /**
   * Add
   */
  public static void ComapringAndCreatingCSVFile(String [][] responseArr, String [] ansArr){

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

    //
    String fileName = "StudentFinalGrade.csv";
    try {
      File file = new File(fileName);
      FileWriter gradeFile = new FileWriter(file);
      for(int x = 0; x < studentResponseIn2DArray.length;x++) {
        gradeFile.write(String.join(",",studentResponseIn2DArray[x]) + "/" + ansArr.length + "\n");
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

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

}

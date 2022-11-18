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
    public static String[][] ReadFileInto2DArray(String filepath, int amountOfFields){
        ArrayList<String> recordsList = new ArrayList <String>();

        //String delimiter = ",";
        String currentLine;

        try{
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);

        while((currentLine = br.readLine()) != null){
            recordsList.add(currentLine);
        }

        int recordCount = recordsList.size();

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
        return arrayToReturn;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
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
    if (scanner.hasNextLine()) {
      number = scanner.nextLine().split(",").length; // It counts the number of columns by separating the strings after the comma and then counting the number of strings
    }
    scanner.close();
    return number;
    }
}

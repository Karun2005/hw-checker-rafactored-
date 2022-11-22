import java.util.Scanner;

class ValidateString {
    /**
     * Validates a string input
     * @return Boolean based on if the user wants to use the equation solver
     */
    public boolean stringInput(){
        System.out.println("Welcome to Student Marking AI V5.3");
        System.out.println("Select one of the options below to continue");
        System.out.println("A. Import answer data and mark student data");
        System.out.println("B. Run equation solver and mark student data");
        final Scanner reader = new Scanner(System.in);
        String choice = reader.nextLine();
    
        while(!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("B")){
          System.out.println("Invalid resonse, try again.");
          choice = reader.nextLine();
        }
        if(choice.equalsIgnoreCase("B")){
            reader.close();
            return true;
        }
        else{
            reader.close();
            return false;
        }
    }
}

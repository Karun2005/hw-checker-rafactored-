import java.util.Scanner;

class ValidateString {
    /*
     *Asks the user wheter they want to compare the student response with either the answer file or by making the computer solve the questions
     *@return true or false(boolean): False is if the user wants to compare using the answer sheet, True if the user wants to compare using the equation solver
     */
    public boolean stringInput(){
        System.out.println("Welcome to Student Marking AI V5.3");
        System.out.println("Select one of the options below to continue");
        System.out.println("A. Import answer data and mark student data");
        System.out.println("B. Run equation solver and mark student data");
        Scanner reader = new Scanner(System.in);
        String choice = reader.nextLine();
    
        while(!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("B")){
          System.out.println("Invalid resonse, try again.");
          choice = reader.nextLine();
        }
        reader.close();
        if(choice.equalsIgnoreCase("B")){
            return true;
        }
        else{
            return false;
        }
    }
}

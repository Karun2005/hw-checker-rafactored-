import java.util.Scanner;

class ValidateString {
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

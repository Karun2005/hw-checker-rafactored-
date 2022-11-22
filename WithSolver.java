//class that runs if user chooses to compare the student response and answer by solving equation
//In our code, class will not be run since it cannot solve the equations
class WithSolver extends DataMethods implements Marks{

    @Override
    public void exportMarks() {
        System.out.println("Using equation solver");  
    }
}

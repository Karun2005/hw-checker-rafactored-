//based on if user chose to compare using the answer file or solving the questions, the designated action will be taken to complete the task
class MarksFactory {
    public Marks getMarks(boolean useEquationSolver){
        if(useEquationSolver){
            return new WithSolver();
        }
        else{
            return new WithoutSolver();
        }
    }
}

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

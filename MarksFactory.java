class MarksFactory {
    /**
     * Creates a class based on the user input
     * @param useEquationSolver
     * @return a class that implements the Marks interface
     */
    public Marks getMarks(boolean useEquationSolver){
        if(useEquationSolver){
            return new WithSolver();
        }
        else{
            return new WithoutSolver();
        }
    }
}

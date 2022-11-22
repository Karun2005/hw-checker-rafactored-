//cleans the question array so that it can be accessed to solve for the values with no trouble 
interface EquationInterface {
    public String[] cleanEquations(String[][] questionData);
    public String[] solveEquation(String[] questionArray);
    public void exportAnswers(String[] answerArray);
}

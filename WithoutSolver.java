class WithoutSolver extends DataMethods implements Marks {
    /**
     * Exports students marks
     */
    @Override
    public void exportMarks() {
        String studentDataFile = verifyFile("student data");
        String studentResponseFile = verifyFile("reponse data");
        String studentAnswerFile = verifyFile("student answer file");
        
        String[][] studentResponseArray = fileTo2DArray(studentResponseFile, getFileColumnsNumber(studentResponseFile));
        
        String[] answerKey = answersToArray(studentAnswerFile);
        String[][] studentFinalGrades = compareResponseToAnswerKey(studentResponseArray, answerKey);
        finalGrade(studentFinalGrades, answerKey.length);
    }
    
}

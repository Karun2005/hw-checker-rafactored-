//class that runs if user chooses to compare the student response and answer by using the answer file
class WithoutSolver extends DataMethods implements Marks {

    @Override
    public void exportMarks() {
        System.out.println("Not using equation Solver");
    }
}

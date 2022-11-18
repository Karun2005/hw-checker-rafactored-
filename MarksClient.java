class MarksClient {
  public static void main(String[] args) {
    ValidateString validater = new ValidateString();
    MarksFactory marksFactory = new MarksFactory();
    Marks marks1 = marksFactory.getMarks(validater.stringInput());
    marks1.exportMarks();
  }
}

public class Practical9 {
  public static void main(String[] args) {
    Practical9 obj = new Practical9();
    int size = Integer.parseInt(args[0]);
    long[] numbers = new long[size];

    for (int i = 0; i < size; i++) {
      numbers[i] = System.nanoTime() % 21 + 1;
    }

    long startTime, endTime, timeTaken;
    long loopTimeTotal = 0;
    long recursionTimeTotal = 0;
    long stringConcatTime = 0;
    long stringBufferTime = 0;
    long stringBuilderTime = 0;
    for (int i = 0; i < size; i++) {
      startTime = System.nanoTime();
      obj.factorialLoop(numbers[i]);
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
      loopTimeTotal += timeTaken;
    }
    long avgLoopTime = loopTimeTotal / size;
    System.out.println("Factorial with loop = " + avgLoopTime);

    for (int i = 0; i < size; i++) {
      startTime = System.nanoTime();
      obj.factorialRecursive(numbers[i]);
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
      recursionTimeTotal += timeTaken;
    }
    long avgRecursionTime = recursionTimeTotal / size;
    System.out.println("Factorial with recursion = " + avgRecursionTime);

    if (avgLoopTime < avgRecursionTime)
      System.out.println("Loop method is faster");
    else if (avgLoopTime == avgRecursionTime)
      System.out.println("Both methods are equally fast");
    else
      System.out.println("Recursion method is faster");

    for (int i = 0; i < size; i++) {
      startTime = System.nanoTime();
      obj.concatWithString(numbers[i]);
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
      stringConcatTime += timeTaken;
    }
    long avgStringConcatTime = stringConcatTime / size;
    System.out.println("String concatenation with String = " + avgStringConcatTime);

    for (int i = 0; i < size; i++) {
      startTime = System.nanoTime();
      obj.concatWithStringBuffer(numbers[i]);
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
      stringBufferTime += timeTaken;
    }
    long avgStringBufferTime = stringBufferTime / size;
    System.out.println("string concatenation with StringBuffer = " + avgStringBufferTime);
    for (int i = 0; i < size; i++) {
      startTime = System.nanoTime();
      obj.concatWithStringBuilder(numbers[i]);
      endTime = System.nanoTime();
      timeTaken = endTime - startTime;
      stringBuilderTime += timeTaken;
    }
    long avgStringBuilderTime = stringBuilderTime / size;
    System.out.println("string with StringBuilder = " + avgStringBuilderTime);

    if (avgStringConcatTime < avgStringBufferTime && avgStringConcatTime < avgStringBuilderTime)
      System.out.println("String method is faster");
    else if (avgStringConcatTime == avgStringBufferTime && avgStringConcatTime == avgStringBuilderTime)
      System.out.println("All methods are equally fast");
    else if (avgStringBufferTime < avgStringBuilderTime)
      System.out.println("stringBuffer  faster");
    else
      System.out.println("stringBuilder faster");
  }
  long factorialLoop(long num) {
    if (num < 0) return -1;
    if (num < 2) return 1;
    long fact = 1;
    for (long i = 2; i <= num; i++) {
      fact *= i;
    }
    return fact;
  }


  long factorialRecursive(long num) {
    if (num < 0) return -1;
    if (num < 2) return 1;
    return num * factorialRecursive(num - 1);
  }
  String concatWithString(long num) {
    String str = "";
    str += num + " ";
    return str;
  }

  StringBuffer concatWithStringBuffer(long num) {
    StringBuffer str = new StringBuffer();
    str.append(num).append(" ");
    return str;
  }
  StringBuilder concatWithStringBuilder(long num) {
    StringBuilder str = new StringBuilder();
    str.append(num).append(" ");
    return str;
  }
}

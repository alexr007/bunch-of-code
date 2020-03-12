package calc;

public class CalcApp {

  public static Operation pick(int op) {
    switch (op) {
      case 1: return new OpAdd();
      case 2: return new OpSub();
      //...
    }
    throw new RuntimeException("Op isn't supported");
  }


  public static void main(String[] args) {
//    Map<String, List<Operation>>
    int op = 1;
    int a = 5;
    int b = 7;
    int c = pick(op).perform(a,b);
  }
}

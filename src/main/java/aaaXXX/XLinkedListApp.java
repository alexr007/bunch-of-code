package aaaXXX;

public class XLinkedListApp {
  public static void main(String[] args) {
    XLinkedList xl = new XLinkedList();
    xl.prepend(1); // 1
    xl.prepend(2); // 2, 1
    xl.prepend(3); // 3, 2, 1
    xl.append(10); // 3, 2, 1, 10
    xl.append(20); // 3, 2, 1, 10, 20
    System.out.println(xl.represent());
//    xl.reverse();
    System.out.println(xl.represent2());
//    xl.reverser();
    System.out.println(xl.represent3r());
  }
}

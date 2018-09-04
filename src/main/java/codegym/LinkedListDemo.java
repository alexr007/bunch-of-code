package codegym;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {

        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<String>();

        // Add few Elements
        list.add("Jack");
        list.add("Robert");
        list.add("Chaitanya");
        list.add("kate");

        // Display LinkList elements
        System.out.println("LinkedList contains: "+list);

        // push Element the list
        list.push("NEW ELEMENT");

        // Display after push operation
        System.out.println("LinkedList contains: "+list);

        list.pop();
        System.out.println("LinkedList contains: "+list);

    }
}
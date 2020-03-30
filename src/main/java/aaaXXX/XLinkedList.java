package aaaXXX;

import java.util.StringJoiner;

public class XLinkedList {

  static class Node {
    final int value;
    Node next;

    Node(int value) {
      this.value = value;
    }

    Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

  }

  Node head = null;

  void prepend(int element) {
    Node node = new Node(element);
    node.next = head;
    head = node;
  }

  void prepend2(int element) {
    head = new Node(element).next = head;
  }

  void prepend3(int element) {
    head = new Node(element, head);
  }

  void append(int element) {
    Node node = new Node(element);
    if (head == null) {
      head = node;
    } else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = node;
    }
  }

  int size() {
    throw new IllegalArgumentException("size:hasn't implemented yet");
  }

  boolean contains(int element){
    throw new IllegalArgumentException("contains:hasn't implemented yet");
  }

  void reverse() {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node savedNext = curr.next;
      curr.next = prev;
      prev = curr;
      curr = savedNext;
    }
    head = prev;
  }

  // tail recursive implementation
  private Node reverser(Node curr, Node prev) {
    if (curr == null) return prev;
    Node savedNext = curr.next;
    curr.next = prev;
    return reverser(savedNext, curr);
  }

  // runner function
  void reverser() {
    head = reverser(head, null);
  }

  void insertBefore(int index, int value) {
    throw new IllegalArgumentException("insertBefore:hasn't implemented yet");
  }

  void insertAfter(int index, int value) {
    throw new IllegalArgumentException("insertAfter:hasn't implemented yet");
  }

  void deleteHead() {
    throw new IllegalArgumentException("deleteHead:hasn't implemented yet");
  }

  void deleteLast() {
    throw new IllegalArgumentException("deleteLast:hasn't implemented yet");
  }

  void deleteAt(int index) {
    throw new IllegalArgumentException("deleteAt:hasn't implemented yet");
  }

  String represent() {
    StringJoiner sj = new StringJoiner(",", "(", ")");
    Node curr = head;
    while (curr != null) {
      sj.add(String.valueOf(curr.value));
      curr = curr.next;
    }
    return sj.toString();
  }
  String represent2() {
    StringJoiner sj = new StringJoiner(",", "(", ")");
    for (Node curr = head; curr != null; curr = curr.next) {
      sj.add(String.valueOf(curr.value));
    }
    return sj.toString();
  }

  /**
   * TO IMPLEMENT RECURSIVE IMPLEMENTATION FOR
   * LIST REPRESENTATION
   */
  private void attach_next(Node curr, StringJoiner sj) {
    if (curr == null) return;
    sj.add(String.valueOf(curr.value));
    attach_next(curr.next, sj);
  }

  public String represent3r() {
    StringJoiner sj = new StringJoiner(",", "(", ")");
    attach_next(head, sj);
    return sj.toString();
  }

}

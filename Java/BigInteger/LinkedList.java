package biginteger;

public class LinkedList {
  private Node first, last;
  private int N;
  
  private class Node {
    private char t;
    private Node prev, next;
    public Node(char t, Node prev, Node next) {
      this.t = t;
      this.prev = prev;
      this.next = next;
    }
  }
  
  public boolean isEmpty() { return first == null; }
  public int size() { return N; }
  public char last() { return last.t; }
  public char first() { return first.t; }
  
  public void addLast(char t) {
    Node x = new Node(t, null, last);
    if (last != null) last.prev = x;
    if (first == null) first = x;
    last = x; N++;
  }
  
  public void addFirst(char t) {
    Node x = new Node(t, first, null);
    if (first != null) first.next = x;
    if (first == null) last = x;
    first = x; N++;
  }
  
  public void setItemAt(int idx, char c) {
    if (idx >= N) { addLast(c); return; }
    Node x = first;
    for (int i = 0; i < idx; i++)
      x = x.prev;
    x.t = c;
  }
  
  public char getItemAt(int idx) {
    if (idx >= N) return '0';
    Node x = first;
    for (int i = 0; i < idx; i++)
      x = x.prev;
    return x.t;
  }
  
  public void print() {
    Node x = last;
    while (x != null) {
      System.out.print(x.t);
      x = x.next;
    }
  }
  
}

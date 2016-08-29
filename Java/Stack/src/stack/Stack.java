/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author yefer
 */
public class Stack {

    private Node first;
    private int size;
    
    private class Node {
        private final int val;
        private final Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(int x) {
        first = new Node(x, first);
        size++;
    }
    
    public int top() {
        if (isEmpty()) return -1;
        return first.val;
    }
    
    public int pop() {
        if (isEmpty()) return 0;
        first = first.next;
        size--;
        return 1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack s = new Stack();
        
        System.out.println("The stack is empty? -> " + s.isEmpty());
        int x = 4;
        s.push(x);
        System.out.println("Push -> " + x);
        System.out.println("The stack is empty? -> " + s.isEmpty());
        x = 2;
        s.push(x);
        System.out.println("Push -> " + x);
        x = 1;
        s.push(x);
        System.out.println("Push -> " + x);
        System.out.println("Top -> " + s.top());
        System.out.println("Size -> " + s.size());
        s.pop();
        System.out.println("Pop");
        System.out.println("Top -> " + s.top());
        System.out.println("Size -> " + s.size());
        s.pop();
        System.out.println("Pop");
        System.out.println("Top -> " + s.top());
        System.out.println("Size -> " + s.size());
        s.pop();
        System.out.println("Pop");
        System.out.println("The stack is empty? -> " + s.isEmpty());
    }

}

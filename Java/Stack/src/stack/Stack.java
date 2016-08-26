/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Yefri97
 */
public class Stack {

    private Node top;
    private int size;
    
    private class Node {
        int val;
        Node next;
        public Node(int _val, Node _next) {
            this.val = _val;
            this.next = _next;
        }
    }
    
    public Stack() {
        this.top = null;
        this.size = 0;
    }
    
    public void push(int x) {
        Node n = new Node(x, );
        if (top == null) {
            Node n = new 
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola");
    }
    
}

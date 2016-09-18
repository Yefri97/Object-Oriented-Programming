package list;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class List {

    private Node Head, Last;
    private int N;
    private int TotalExch;
    private int Exch;
    
    private class Node {
        private Node next;
        private int key;
        public Node(int k) {
            this.key = k;
            this.next = null;
        }
    }
    
    public List() {
        Node x = new Node(-1);
        Head = Last = x;
    }
    
    public int size() { return N; }
    
    public void add(int k) {
        Node x = new Node(k);
        Last.next = x;
        Last = x; N++;
    }
    
    public void print() {
        Node x = Head.next;
        while (x != null) {
            System.out.print(x.key + " ");
            x = x.next;
        }
        System.out.print("\n");
    }
    
    public static void bubbleHSort(List l, int h) {
        if (h > l.size() - 1) return;
        l.Exch = 0;
        for (int i = 0; i < Math.ceil((double) l.size() / h) - 1; i++) {
            int flag = 1;
            Node tortoise, hare;
            tortoise = hare = l.Head;
            int hc = h;
            while (hc-- > 0) hare = hare.next;
            while (hare.next != null) {
                if (hare.next.key < tortoise.next.key) {
                    Node pa = tortoise, a = pa.next, sa = a.next;
                    Node pb = hare, b = pb.next, sb = b.next;
                    a.next = sb;
                    pa.next = b;
                    if (sa == b) {
                        b.next = a;
                        hare = tortoise.next;
                    } else {
                        b.next = sa;
                        pb.next = a;
                    }
                    l.Exch++;
                    flag = 0;
                }
                tortoise = tortoise.next;
                hare = hare.next;
            }
            if (flag == 1) break;
        }
    }
    
    public static void shellSort(List l) {
        
        int n_seq = (int) (Math.log(2 * l.size() - 1) / Math.log(3));
        int[] seq = new int[n_seq];
        for (int i = 0, k = 3; i < n_seq; i++, k *= 3)
            seq[i] = (k - 1) / 2;
        
        System.out.println("Secuencia de h a evaluar:");
        for (int i = 0; i < seq.length; i++)
            System.out.print(seq[i] + " ");
        System.out.println("\n");
        
        l.TotalExch = 0;
        for (int i = seq.length - 1; i >= 0; i--) {
            bubbleHSort(l, seq[i]);
            
            System.out.println("Con h = " + seq[i]);
            if (l.size() < 22) l.print();
            System.out.println("Numero de cambios: " + l.Exch);
            System.out.print("\n");
            l.TotalExch += l.Exch;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner sc = new Scanner(new File("/home/yefer/in.txt"));

        List l = new List();
        
        while (sc.hasNextInt()) {
          l.add(sc.nextInt());
        }
        
        if (l.size() < 22) {
            System.out.println("Lista a ordenar:");
            l.print(); System.out.print("\n");
        }
        
        shellSort(l);
        
        if (l.size() < 22) {
            System.out.println("Lista ordenada:");
            l.print();
        }
        
        System.out.println("Total Exch: " + l.TotalExch);
    }
    
}

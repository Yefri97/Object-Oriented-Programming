package list;

public class List {

    private Node Head;
    private int N;
    
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
        Head = x;
    }
    
    public void add(int k) {
        Node x = new Node(k);
        x.next = Head.next;
        Head.next = x;
    }
    
    public void print() {
        Node x = Head.next;
        while (x != null) {
            System.out.print(x.key + " ");
            x = x.next;
        }
        System.out.print("\n");
    }
    
    public static void shellSort(List l, int v[]) {
        for (int i = 0; i < v.size(); i++)
            shell(l, v[i]);
    }
    
    public static void main(String[] args) {
        List l = new List();
        for (int i = 0; i < 10; i++)
            l.add(i);
        l.print();
    }
    
}

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
    
    public static void shell(List l, int h) {
        int hc = h;
        Node init = l.Head;
        while (hc-- > 0) {
            Node hare = init, prev = null;
            for (int i = 0; hare.next != null; i = (i + 1) % h) {
                if (i == 0) {
                    Node tortoise = prev;
                    
                    // Casos iniciales
                    int tn = h - 3;
                    while (tn-- > 0 && tortoise != null) tortoise = tortoise.next;
                    
                    // Programar burbuja
                    for (int j = 0; tortoise != null; j = (j + 1) % h) {
                        if (j == 0) {
                            if (hare.next.key < tortoise.next.key) {
                                Node hn = hare.next, hnn = hare.next.next;
                                hare.next = tortoise.next;
                                tortoise.next = hn;
                                hn.next = hare.next.next;
                                hare.next = hnn;
                                
                            } else
                                break;
                        }
                        tortoise = tortoise.next;
                    }
                    
                }
                Node temp = hare;
                hare = hare.next;
                temp.next = prev;
                prev = temp;
            }
            
            // Reorganizar lista
            
            init = init.next;
        }
    }
    
    public static void shellSort(List l, int v[]) {
        for (int i = v.length - 1; i >= 0; i--)
            shell(l, v[i]);
    }
    
    public static void main(String[] args) {
        List l = new List();
        for (int i = 0; i < 10; i++)
            l.add(i);
        l.print();
        int seq[] = {1, 4};
        //System.out.print(seq.length + "\n");
        shellSort(l, seq);
    }
    
}

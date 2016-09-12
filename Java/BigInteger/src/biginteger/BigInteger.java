package biginteger;

public class BigInteger {
    
    private LinkedList number;
    
    public BigInteger(String s) {
        this.number = new LinkedList();
        for (int i = 0; i < s.length(); i++)
            this.number.addFirst(s.charAt(i));
    }
    
    public int size() { return number.size(); }
    public void print() { number.print(); }
    public void setDigAt(int idx, int dig) { number.setItemAt(idx, (char) (dig + '0')); }
    public int getDigAt(int idx) { return number.getItemAt(idx) - '0'; }
    
    public void add(BigInteger n) {
        int len = Math.max(size(), n.size());
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int num = getDigAt(i) + n.getDigAt(i) + carry;
            setDigAt(i, num % 10);
            carry = num / 10;
        }
        if (carry != 0) setDigAt(size(), carry);
    }
    
    public void multi(BigInteger n) {
        BigInteger ans, temp;
        ans = new BigInteger("0");
        for (int i = 0; i < n.size(); i++) {
            temp = new BigInteger("0");
            int b = n.getDigAt(i);
            int carry = 0;
            for (int j = 0; j < size(); j++) {
                int a = getDigAt(j);
                int num = a * b + carry;
                temp.setDigAt(j, num % 10);
                carry = num / 10;
            }
            if (carry != 0) temp.setDigAt(temp.size(), carry);
            for (int j = 0; j < i; j++) temp.number.addFirst('0');
            ans.add(temp);
        }
        number = ans.number;
    }
    
    public static void main(String[] args) {
        BigInteger bi1, bi2;
        
        bi1 = new BigInteger("99999");
        bi2 = new BigInteger("1");
        bi1.print();
        System.out.print(" + ");
        bi2.print();
        System.out.print(" = ");
        bi1.add(bi2);
        bi1.print();
        System.out.print("\n");
        
        bi1 = new BigInteger("12345");
        bi2 = new BigInteger("98766");
        bi1.print();
        System.out.print(" + ");
        bi2.print();
        System.out.print(" = ");
        bi1.add(bi2);
        bi1.print();
        System.out.print("\n");
        
        bi1 = new BigInteger("12345");
        bi2 = new BigInteger("2");
        bi1.print();
        System.out.print(" * ");
        bi2.print();
        System.out.print(" = ");
        bi1.multi(bi2);
        bi1.print();
        System.out.print("\n");
        
        bi1 = new BigInteger("1234512314546578785454512156456144789423");
        bi2 = new BigInteger("1000000000000000000");
        bi1.print();
        System.out.print(" * ");
        bi2.print();
        System.out.print(" = ");
        bi1.multi(bi2);
        bi1.print();
        System.out.print("\n");
    }
    
}

package Hashing;

public class HashLinearChain {
    
    private int size;
    private final int capacity = 500000;
    private LinkedList[] table;
   
    public HashLinearChain() {
        table = new LinkedList[capacity];
        size = 0;
    }
    
    private int hash(String val) { return (Math.abs(val.hashCode()) % capacity); }

    public void add(String val) {
	int pos = hash(val);
        if (table[pos] == null) {
            table[pos] = new LinkedList();
            table[pos].addStart(val);
            size++;
            return;
        }
        table[pos].addStart(val);
        size++;
    }
    
    public void remove(String val) {
        int pos = hash(val);
        if (table[pos] != null)
            for (int i = 0; i < table[pos].size(); i++)
                if (table[pos].get(i).equals(val)) {
                    table[pos].remove(i);
                    size--;
                }
    }
    
    public boolean contains(String val) {
        int pos = hash(val);
        if (table[pos] != null)
            for (int i = 0; i < table[pos].size(); i++)
                if (table[pos].get(i).equals(val))
                    return true;
        return false;
    }
    
    public int size() { return size; }
    
    public void print() {
        for (int i = 0; i < capacity; i++)
            if (table[i] != null)
                for (int j = 0; j < table[i].size(); j++)
                    System.out.println(table[i].get(j));
    }
    
    public void computeHistogram() {
        int[] hist = new int[10];
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null)
                hist[0]++;
            else if (table[i].size() >= 9)
                hist[9]++;
            else
                hist[table[i].size()]++;
        }
        for (int i = 0; i < hist.length; i++)
            if (hist[i] != 0)
                System.out.println("Bin " + i + ": " + hist[i]);
    }
}
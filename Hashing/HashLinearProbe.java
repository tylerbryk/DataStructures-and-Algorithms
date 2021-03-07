package Hashing;

class HashLinearProbe {
    
    private int size;
    private int capacity = 500000;
    private Node[] table;
    
    private static class Node {
        private String val;
        private boolean isDeleted;
        public Node(String val) {
            this.val = val;
            isDeleted = false;
        }
    }
   
    public HashLinearProbe() {
        table = new Node[capacity];
        size = 0;
    }
    
    private int hash(String val) { return (Math.abs(val.hashCode()) % capacity); }
    
    private void checkGrow() {
        if (size / capacity >= 0.7) {
            Node[] temp = table;
            table = new Node[capacity*2];
            System.arraycopy(temp, 0, table, 0, capacity); // WRONG: Should re-hash values
            capacity *= 2;
        }
    }
    
    public void add(String val) {
        checkGrow();
        int pos = hash(val);
        if (table[pos] == null || table[pos].isDeleted)
            table[pos] = new Node(val);
        else {
            int probe = pos;
            while (table[probe] != null && table[pos].isDeleted == false) {
                probe++;
                if (probe == capacity)
                    probe = 0;
            }
            table[probe] = new Node(val);
        }
        size++;
    }
    
    public boolean contains(String val) {
        int pos = hash(val);
        while (table[pos] != null) {
            if (table[pos].val.equals(val) && !table[pos].isDeleted)
                return true;
            if (table[pos] == null)
                return false;
            pos++;
        }
        return false;
    }
    
    public void remove(String val) {
        int pos = hash(val);
        while (table[pos] != null) {
            if (table[pos].val.equals(val) && !table[pos].isDeleted) {
                table[pos].isDeleted = true;
                size--;
                return;
            }
            if (table[pos] == null)
                return;
            pos++;
        }
    }
    
    public int size() { return size; }
    
    public void print() {
        for (int i = 0; i < capacity; i++)
            if (table[i] != null && !table[i].isDeleted)
                System.out.println(table[i].val);
    }
}
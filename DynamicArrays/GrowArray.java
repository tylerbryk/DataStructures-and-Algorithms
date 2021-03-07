package DynamicArrays;

class GrowArray {
    private float[] data;
    private int space;
    private int length;
    
    public GrowArray() {
        data = new float[1];
        space = 1;
        length = 0;
    }
    public GrowArray(int n) {
        data = new float[n];
        space = n;
        length = 0;
    }
    
    private void checkGrow() {
        if (length >= space) {
            space *= 2;
            float temp[] = data;
            data = new float[space];
            System.arraycopy(temp,0 , data,0 , length);
        }
    }
    
    public int size() { return length; }
    public float get(int i) { return data[i]; }
    public void set(int i, float v) { data[i] = v; }
    
    public void addEnd(float v) {
        checkGrow();
        data[length++] = v;
    }
    
    public void addStart(float v) {
        checkGrow();
        for (int i = length++; i > 0; i--)
            data[i] = data[i-1];
        data[0] = v;
    }
    
    public void add(int idx, float v) {
        checkGrow();
        for (int i = length++; i > idx; i--)
            data[i] = data[i-1];
        data[idx] = v;
    }
    
    public void removeEnd() {
        length--;
    }
    
    public void removeStart() {
        for (int i = 0; i < length; i++)
            data[i] = data[i+1];
        length--;
    }
    
    public void remove(int idx) {
        for (int i = idx; i < length; i++)
            data[i] = data[i+1];
        length--;
    }
}
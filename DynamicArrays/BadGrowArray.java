package DynamicArrays;

// Delete Temp[] Array

public class BadGrowArray {
    private int[] data;
    
    public BadGrowArray() {
        data = new int[0];
    }
    
    public int size() { return data.length; }
    
    public void addEnd(int v) {
        int[] temp = data;
        data = new int[temp.length+1];
        System.arraycopy(temp, 0, data, 0, temp.length);
        data[temp.length] = v;
    }
    
    public void addStart(int v) {
        int[] temp = data;
        data = new int[temp.length+1];
        data[0] = v;
        System.arraycopy(temp, 0, data, 1, temp.length); 
    }
    
    public void add(int i, int v) {
        int[] temp = data;
        data = new int[temp.length+1];
        System.arraycopy(temp, 0, data, 0, i);
        data[i] = v;
        System.arraycopy(temp, i, data, i + 1, temp.length - i);
    }
    
    public void removeEnd() {
        int[] temp = data;
        data = new int[temp.length-1];
        System.arraycopy(temp, 0, data, 0, temp.length-1); 
    }
    
    public void removeStart() {
        int[] temp = data;
        data = new int[temp.length-1];
        for (int i = 0; i < temp.length-1; i++)
            data[i] = temp[i+1];
    }
    
    public void remove(int pos) {
        int[] temp = data;
        data = new int[temp.length-1];
        for (int i = 0; i < pos; i++)
            data[i] = temp[i];
        for (int i = pos; i < temp.length-1; i++)
            data[i] = temp[i+1];
    }
    
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(11*data.length);
        for(int i = 0; i < data.length; i++)
            b.append(data[i]).append(" ");
        return b.toString();
    }
    
    public Object clone() {
        BadGrowArray copy = new BadGrowArray();
        copy.data = new int[this.data.length];
        System.arraycopy(this.data, 0, copy.data, 0, data.length);
        return copy;
    }
}
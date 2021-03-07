package MidtermMaterial.SortingAlgorithms;

class HeapSort {
    // O(NLog(N))
    public static void heapSort(int x[]) { 
        for (int i = x.length/2-1; i >= 0; i--) 
            checkHeap(x, x.length, i); 
        for (int i = x.length-1; i >= 0; i--) { 
            int temp = x[0]; 
            x[0] = x[i]; 
            x[i] = temp; 
            checkHeap(x, i, 0); 
        }
    } 

    private static void checkHeap(int x[], int len, int i) { 
        int root = i;
        int L = 2*i + 1;
        int R = 2*i + 2;
        if (L < len && x[L] > x[root]) 
            root = L;
        if (R < len && x[R] > x[root]) 
            root = R; 
        if (root != i) { 
            int swap = x[i]; 
            x[i] = x[root]; 
            x[root] = swap; 
            checkHeap(x, len, root); 
        } 
    } 
    
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {2,4,6,1,9,5,8,3,7}; 
        heapSort(x); 
        printArray(x); 
    } 
}

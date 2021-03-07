package MidtermMaterial.SortingAlgorithms;

class QuickSort {
    // O(NLog(N)) worst case is O(N^^2)
    public static void quickSort(int x[], int L, int R) { 
        if (L < R) { 
            int p = partition(x, L, R); 
            quickSort(x, L, p-1); 
            quickSort(x, p+1, R); 
        } 
    } 
    
    public static int partition(int x[], int L, int R) { 
        int piv = R;
        int i = L; 
        for (int j = L; j < R; j++)
            if (x[j] < x[piv]) {  
                int temp = x[i]; 
                x[i] = x[j]; 
                x[j] = temp; 
                i++;
            } 
        int temp = x[i]; 
        x[i] = x[piv]; 
        x[piv] = temp; 
        return i; 
    }

    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {2,4,6,1,9,5,8,3,7}; 
        quickSort(x, 0, x.length-1); 
        printArray(x); 
    } 
}
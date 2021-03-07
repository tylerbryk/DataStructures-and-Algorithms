package SortingAlgorithms;

class MergeSort {
    // O(NLog(N))
    public static void mergeSort(int x[], int L, int R) { 
        if (L < R) { 
            int m = (L+R)/2; 
            mergeSort(x, L, m); 
            mergeSort(x , m+1, R); 
            merge(x, L, m, R); 
        } 
    }
    
    private static void merge(int x[], int l, int m, int r) { 
        int lenL = m - l + 1; 
        int lenR = r - m; 
        int[] L = new int [lenL]; 
        int[] R = new int [lenR]; 
        for (int i = 0; i < lenL; i++) 
            L[i] = x[l+i]; 
        for (int i = 0; i < lenR; i++) 
            R[i] = x[m+1+i];  
        int i = 0, j = 0, k = l; 
        while (i < lenL && j < lenR) { 
            if (L[i] < R[j])
                x[k++] = L[i++];  
            else 
                x[k++] = R[j++]; 
        } 
        while (i < lenL)
            x[k++] = L[i++];  
        while (j < lenR)
            x[k++] = R[j++]; 
    } 
  
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {17,20,37218,56,1,37,2,37,34}; 
        mergeSort(x, 0, x.length-1); 
        printArray(x); 
    } 
}

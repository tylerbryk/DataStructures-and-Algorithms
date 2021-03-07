package SortingAlgorithms;

class InsertionSort {
    // O(N^^2)
    public static void insertionSort(int x[]) {  
        for (int i = 1; i < x.length; i++) { 
            int key = x[i]; 
            int j = i - 1; 
            while (j >= 0 && x[j] > key) 
                x[j+1] = x[j--];  
            x[j+1] = key; 
        }
    } 
    
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {6,8,2,2,1,7,5,10}; 
        insertionSort(x); 
        printArray(x); 
    } 
}
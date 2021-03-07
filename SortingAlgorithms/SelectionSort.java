package SortingAlgorithms;

class SelectionSort {
    // O(N^^2)
    public static void selectionSort(int x[]) {  
        for (int i = 0; i < x.length-1; i++) { 
            int min = i; 
            for (int j = i+1; j < x.length; j++) 
                if (x[j] < x[min]) 
                    min = j; 
            int temp = x[min]; 
            x[min] = x[i]; 
            x[i] = temp; 
        } 
    } 
    
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {1,7,3,6,2,4,8,5}; 
        selectionSort(x); 
        printArray(x); 
    }
}
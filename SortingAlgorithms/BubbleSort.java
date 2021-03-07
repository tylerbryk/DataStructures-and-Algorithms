package SortingAlgorithms;

class BubbleSort {
    // O(N^^2)
    public static void bubbleSort(int x[]) {  
        for (int i = 0; i < x.length-1; i++) 
            for (int j = 0; j < x.length-1-i; j++) 
                if (x[j] > x[j+1]) { 
                    int temp = x[j]; 
                    x[j] = x[j+1]; 
                    x[j+1] = temp; 
                } 
    } 
  
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String args[]) { 
        int x[] = {1,7,3,6,2,4,8,5}; 
        bubbleSort(x); 
        printArray(x); 
    } 
}
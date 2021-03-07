package SearchingAlgorithms;

class LinearSearch {
    // O(N) - Worst Case = Average Case
    public static int linearSearch(int x[], int t) {  
        for(int i = 0; i < x.length; i++)  
            if(x[i] == t) 
                return i; 
        return -1; 
    } 
  
    public static void main(String args[]) { 
        int x[] = {2, 3, 4, 10, 40};  
        System.out.println("Position: " + linearSearch(x,400));
    } 
}
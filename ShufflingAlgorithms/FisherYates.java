package ShufflingAlgorithms;

class FisherYates {
    // O(N)
    public static void fisherYates(int x[]) { 
        for (int i = x.length-1; i > 0; i--) { 
            int r = (int)(Math.random() * i); 
            int temp = x[i]; 
            x[i] = x[r]; 
            x[r] = temp; 
        }  
    } 
    // O(N)
    public static void badShuffle(int x[]) { 
        for (int i = 0; i < x.length; i++) {
            int r = (int)(Math.random() * (x.length-1));
            int t = x[r];
            x[r] = x[i];
            x[i] = t;
        }
    } 
    
    public static void printArray(int x[]) { 
        for (int i = 0; i < x.length; i++) 
            System.out.print(x[i] + " "); 
        System.out.println(); 
    } 
      
    public static void main(String[] args) { 
         int[] x = {1, 2, 3, 4, 5, 6, 7, 8}; 
         fisherYates(x);
         printArray(x);
    } 
} 
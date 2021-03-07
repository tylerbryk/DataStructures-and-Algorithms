package StringAlgorithms;

public class NaiveSearch {
    // O(kn) = O(search-key)
    public static void naiveSearch(String src, String key) { 
        int M = key.length(); 
        int N = src.length(); 
        for (int i = 0; i <= N - M; i++) { 
            int j; 
            for (j = 0; j < M; j++) 
                if (src.charAt(i + j) != key.charAt(j)) 
                    break; 
            if (j == M) 
                System.out.println("Pattern found at index " + i); 
        } 
    } 
  
    public static void main(String[] args) { 
        String search = "hello my name is tyler"; 
        String key = "name"; 
        naiveSearch(search, key); 
    } 
} 
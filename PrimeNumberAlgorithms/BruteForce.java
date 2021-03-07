package MidtermMaterial.PrimeNumberAlgorithms;

class BruteForce {
    // O(N)
    public static boolean BFR(int n) {
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
    
    // O(SQRT(N))
    public static boolean BFS(int n) {
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
        
    public static void main(String[] args) {
        System.out.println(BFR(25117));
    } 
}

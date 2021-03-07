package PrimeNumberAlgorithms;

class FermatsLittle {
    // O(KLogN)
    public static long powerMod(long a, long b, long r) { 
	long prod = 1; 
	while (b > 0) { 
            if ((b & 1) == 1) 
                prod = (prod * a) % r; 
            b /= 2;
            a = (a * a) % r; 
        } 
	return prod; 
    }   
    
    public static boolean fermat(long n, int k) { 
        if (n <= 1) return false; 
        if (n <= 2) return true; 
        for (int i = 0; i < k; i++) { 
            int a = 2 + (int)(Math.random() % (n - 2));  
            if (powerMod(a, n - 1, n) == 1) 
                return true; 
        } 
        return false; 
    } 
       
    public static void main(String args[]) { 
        long num = 561;
        int iteration = 10;  
        System.out.println("Primality for " + num + " is: " + fermat(num,iteration));
    } 
}
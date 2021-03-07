package PrimeNumberAlgorithms;

class MillerRabin {
    // O(K(LogN)^3)
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
	
    public static boolean millerRabin(long n, int k) { 
        if (n <= 1) return false; 
        if (n <= 2) return true; 

        long d = n - 1; 
        while (d % 2 == 0) 
            d /= 2; 
 
        for (int i = 0; i < k; i++) {
            long a = 2 + (long)(Math.random() % (n - 2)); 
            long p = powerMod(a, d, n); 
            if (p == 1 || p == n - 1) 
                return true; 
            while (d != n - 1) { 
                p = (p * p) % n; 
                d *= 2; 
                if (p == 1) 
                    return false; 
                if (p == n - 1) 
                    return true; 
            } 
        }
        return false; 
    } 
	
    public static void main(String args[]) { 		
        long num = 500009;
        int iteration = 10;  
        System.out.println("Primality for " + num + " is: " + millerRabin(num,iteration));
    } 
}
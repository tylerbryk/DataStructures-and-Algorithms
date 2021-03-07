package PrimeNumberAlgorithms;

class EratosthenesSieve {
    // O(NLogLogN)
    public static boolean eratosthenes(int n) { 
        boolean[] primes = new boolean[n+1];
        for (int i = 0; i <= n; i++)
            primes[i] = true;
        for (int i = 4; i <= n; i += 2)
            primes[i] = false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (primes[i])
                for (int j = i*i; j <= n; j += 2*i)
                    primes[j] = false;
        return primes[n];
    } 
    
    public static void main(String[] args) {
        System.out.println(eratosthenes(561));
    }
}
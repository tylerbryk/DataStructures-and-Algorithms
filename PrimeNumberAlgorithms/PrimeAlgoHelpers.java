class PrimeAlgoHelpers {
    // O(LogN) 
    public static int GCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    // O(LogN)
    public static int LCM(int a, int b) {
        return a * b / GCD(a,b);
    }
    // O(LogN)
    public static int powerMod(int a, int b, int r) {
        int product = 1;
        while (b > 0) {
            if (b % 2 != 0)
                product = (product * a) % r;
            a = (a * a) % r;
            b /= 2;
        }
        return product;
    }
    
    public static int power(int a, int b) {
        int product = 1;
        while (b > 0) {
            if (b % 2 != 0)
                product = product * a;
            a = a * a;
            b /= 2;
        }
        return product;
    }
        
    public static void main(String args[]) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int r = Integer.parseInt(args[2]);
        System.out.println("\nGCD of " + a + " and " + b + " is " + GCD(a,b));
        System.out.println("LCM of " + a + " and " + b + " is " + LCM(a,b));
        System.out.println(a + " to the " + b + "th power % " + r + " is " + powerMod(a,b,r) + "\n");
    }
}

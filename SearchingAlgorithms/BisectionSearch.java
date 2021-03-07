package SearchingAlgorithms;

class BisectionSearch {
     
    public static double func(double x) { 
        return x*x*x - x*x + 2; 
    } 
  
    public static double bisection(double a, double b, double e) { 
        if (func(a) * func(b) >= 0)
            throw new RuntimeException("There may not be a root!"); 
        double mid = a; 
        while (b - a >= e) {  
            mid = (a+b) / 2; 
            if (func(mid) == 0.0) 
                break; 
            else if (func(mid) * func(a) < 0) 
                b = mid; 
            else
                a = mid; 
        } 
        return mid; 
    } 

    public static void main(String[] args) { 
        System.out.println(bisection(-200, 300, 0.01)); 
    } 
    
}
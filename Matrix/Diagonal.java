package Matrices;

public class Diagonal {
    private static int N;
    private static double[] matrix;

    public Diagonal(int n) {
        N = n;
        matrix = new double[N];
    }
    
    public int getSize() { return N; };
  
    public double get(int r, int c) {
        if (r == c)
            return matrix[r];
        return 0;
    }
    
    public void set(int r, int c, double v) {
        if (r == c)
            matrix[r] = v;
    }

    public void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(matrix[i] + "  ");
            for (int j = 0; j < N; j++) {
                if (i+j % N-(N-1) == 0)
                    System.out.println();
                if (i != N-1)
                    System.out.print("0.0  ");
            }
        }
    }
    
    public Diagonal add(Diagonal b) {
        if (N != b.getSize())
            throw new RuntimeException("Matrix sizes do not match!");
        Diagonal result = new Diagonal(N);
        for (int i = 0; i < N; i++)
            result.set(i,i, get(i,i) + b.get(i,i));
        return result;
    }
    
    public Diagonal multiply(Diagonal b) {
        if (N != b.getSize())
            throw new RuntimeException("Matrix sizes do not match!");
        Diagonal result = new Diagonal(N);
        for (int i = 0; i < N; i++)
            result.set(i,i, get(i,i) * b.get(i,i));
        return result;
    }
}
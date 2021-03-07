package Matrices;

public class TriDiagonal {
    private static int N;
    private static double[] matrix;

    public TriDiagonal(int n) {
        N = n;
        matrix = new double[3*n-2];
    }
  
    public int getSize() { return N; };
    
    public double get(int r, int c) {
        if (Math.abs(r-c) <= 1)
            return matrix[2*r + c];
        return 0;
    }
    
    public void set(int r, int c, double v) {
        if (Math.abs(r-c) <= 1)
            matrix[2*r + c] = v;
    }
    
    public void print() {
        int i,j,k,s;
        for(i = 0; i < N; i++) {
            System.out.println();
            for(s = 0; s < i-1; s++)
                System.out.print("0.0  ");
            for(j = i-1; j <= i+1; j++) {
                if(j == -1 || j == N)
                    continue;
                k = 2*i + j;
                System.out.print(matrix[k] + "  ");
            }
        }
    }
    

    public TriDiagonal add(TriDiagonal b) {
        if (N != b.getSize())
            throw new RuntimeException("Matrix sizes do not match!");
        TriDiagonal result = new TriDiagonal(N);
        for (int i = 0; i < N; i++) {
            result.set(i,i-1,  get(i,i-1)*b.get(i-1,i-1) + get(i,i)*b.get(i,i-1));
            result.set(i,i,    get(i,i-1)*b.get(i-1,i) + get(i,i)*b.get(i,i) + get(i, i+1)*b.get(i+1,i));
            result.set(i,i+1,  get(i,i)*b.get(i,i+1) + get(i,i+1)*b.get(i+1,i+1));
        }
        return result;
    }
    
    public TriDiagonal multiply(TriDiagonal b) {
        if (N != b.getSize())
            throw new RuntimeException("Matrix sizes do not match!");
        TriDiagonal result = new TriDiagonal(N);
        for (int i = 0; i < N; i++) {
            result.set(i,i-1,  get(i,i-1)*b.get(i-1,i-1) + get(i,i)*b.get(i,i-1));
            result.set(i,i,    get(i,i-1)*b.get(i-1,i) + get(i,i)*b.get(i,i) + get(i, i+1)*b.get(i+1,i));
            result.set(i,i+1,  get(i,i)*b.get(i,i+1) + get(i,i+1)*b.get(i+1,i+1));
        }
        return result;
    }
}
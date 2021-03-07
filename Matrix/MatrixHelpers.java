import java.io.File;
import java.util.Scanner;

class Matrix {
    
    private static int N;
    private static double[] B;
    private static double[] matrix;
    
    public Matrix(File file) throws Exception {
        Scanner s1 = new Scanner(file);
        N = s1.nextInt();
        matrix = new double[N*N];
        B = new double[N];
        for (int i = 0; i < N*N; i++)
            matrix[i] = s1.nextDouble();
        for (int i = 0; i < N; i++)
            B[i] = s1.nextDouble();
    }
    
    public double get(int r, int c) { return matrix[r * N + c]; }
    public void set(int r, int c, double v) { matrix[r * N + c] = v; }
    
    
    public void print() {
        for (int i = 0; i < N*N; i++) {
            if (i != 0 && i % N == 0)
                System.out.println();
            System.out.print(matrix[i] + " ");
        }
    }
    
    private void swap(int row1, int row2) {
        double[] temp = new double[N];
        for (int i = 0; i < N; i++)
            temp[i] = get(row1,i);
        for (int i = 0; i < N; i++) {
            set(row1,i,get(row2,i));
            set(row2,i,temp[i]);
        }
    }
    
    private void pivot(int i) {
        for (int k = i+1; k < N; k++) {
            double alpha = get(k,i) / get(i,i);
            B[k] -= alpha * B[i];
            for (int j = i; j < N; j++)
                set(k,j, get(k,j) - alpha*get(i,j));
        }
    }
    
    private double[] backSub() {
        double[] x = new double[N];
        for (int i = N-1; i >= 0; i--) {
            double sum = 0;
            for (int j = i+1; j < N; j++)
                sum += get(i,j) * x[j];
            x[i] = (B[i] - sum) / get(i,i);
        }
        return x;
    }
    
    public double[] solve(double[] B) {
        for (int i = 0; i < N; i++) {
            int max = i;
            for (int j = i+1; j < N; j++)
                if (Math.abs(get(j,i)) > Math.abs(get(max,i)))
                    max = j;
            
            swap(i,max);
            double b = B[i];
            B[i] = B[max];
            B[max] = b;
            
            if (Math.abs(get(i,i)) <= 0.001)
                throw new RuntimeException("Matrix is singular!");
            
            pivot(i);
        }
        return backSub();
    }
    
    public static void main(String[] args) throws Exception {
        Matrix mat = new Matrix(new File("mat.dat"));
        double[] x = mat.solve(B);
        for (int i = 0; i < x.length; i++)
            System.out.println("|  " + x[i] + "\t|");
    }
}
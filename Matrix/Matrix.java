package Matrices;

import java.io.File;
import java.util.Scanner;

public class Matrix {
    
    private static int row, col, N;
    private static double[] matrix;
    private static double[] B;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new double[row*col];
    }
    
    public Matrix(File file) throws Exception {
        Scanner s1 = new Scanner(file);
        N = s1.nextInt();
        row = col = N;
        matrix = new double[N*N];
        B = new double[N];
        for (int i = 0; i < N*N; i++)
            matrix[i] = s1.nextDouble();
        for (int i = 0; i < N; i++)
            B[i] = s1.nextDouble();
    }
    
    public int getRow() { return row; }
    public int getCol() { return col; }
    public double get(int r, int c) { return matrix[r * col + c]; }
    public void set(int r, int c, double v) { matrix[r * col + c] = v; }
    
    
    public void print() {
        for (int i = 0; i < row*col; i++) {
            if (i != 0 && i % col == 0)
                System.out.println();
            System.out.print(matrix[i] + " ");
        }
    }
    
    // O(N)
    private void swap(int row1, int row2) {
        double[] temp = new double[N];
        for (int i = 0; i < N; i++)
            temp[i] = get(row1,i);
        for (int i = 0; i < N; i++) {
            set(row1,i,get(row2,i));
            set(row2,i,temp[i]);
        }
    }
    
    // O(N^2)
    private void pivot(int i) {
        for (int k = i+1; k < N; k++) {
            double alpha = get(k,i) / get(i,i);
            B[k] -= alpha * B[i];
            for (int j = i; j < N; j++)
                set(k,j, get(k,j) - alpha*get(i,j));
        }
    }
    
    // O(N^2)
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
    
    public double[] solve() {
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

    public Matrix add(Matrix b) {
        if (row != b.getRow() || col != b.getCol())
            throw new RuntimeException("Matrix sizes do not match!");
        Matrix result = new Matrix(row,col);
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                result.set(i,j,get(i,j) + b.get(i,j));
        return result;
    }
    
    public Matrix multiply(Matrix b) {
        if (col != b.getRow())
            throw new RuntimeException("Matrix sizes do not match!");
        Matrix result = new Matrix(col,b.getRow());
        for (int i = 0; i < row; i++)
            for (int j = 0; j < b.getCol(); j++) {
                int sum = 0;
                for (int k = 0; k < col; k++)
                    sum += get(i,k) * b.get(k,j);
                result.set(i,j,sum);
            }
        return result;
    }
}
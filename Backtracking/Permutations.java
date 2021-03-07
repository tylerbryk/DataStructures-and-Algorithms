package Backtracking;

// O(N!)
public class Permutations {

    private int[] list;
	
    private void swap(int i, int j) {
        int temp = list[i]; 
        list[i] = list[j]; 
        list[j] = temp;
    }

	
    public void doit() {
	for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
	System.out.println();
    }
	
    public void heaps(int N) {
	if (N == 0) {
            doit();
            return;
	}
	for (int i = 0; i <= N; i++) {
            swap(N % 2 != 0 ? 0 : i, N);
            heaps(N-1);
	}
    }
  
    public void sedgewick(int N) {
	if (N == 0) {
            doit();
            return;
	}
	for (int i = 0; i <= N; i++) {
            swap(i, N);
            sedgewick(N-1);
            swap(i, N);
	}
    }

    public Permutations(int[] list) {
	this.list = list;
        int N = list.length;
	heaps(N-1); System.out.println();
        sedgewick(N-1);
    }
	
    public static void main(String[] args) {
	int[] x = {1, 2, 3, 4};
	new Permutations(x);
    }
}
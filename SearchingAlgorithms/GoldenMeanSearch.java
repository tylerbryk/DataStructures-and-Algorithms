package SearchingAlgorithms;

class GoldenMeanSearch {

    public static double PHI = (Math.sqrt(5)+1) / 2;
    
    public static int goldenMeanSearch(int[] x, int L, int R) {
	int S = (int)((R - L) / PHI);
        while (R-L > 2) {
            int X = R - S;
            int Y = L + S;
            if (x[X] > x[Y]) {
		R = Y;
		Y = X;
		S = (int)((R - L) / PHI);
		X = R-S;
            } else {
		L = X;
		X = Y;
		S = (int)((R - L) / PHI);
		Y = L+S;
            }
	}
	return L;
    }
	
    public static void main(String[] args) {
        int[] x = {-30, -12, -11, -10, -5, -3, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8};	
        System.out.println(x[goldenMeanSearch(x, 0, x.length-1)]);
    }	
}
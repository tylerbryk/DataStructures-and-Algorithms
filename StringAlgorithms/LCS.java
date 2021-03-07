package StringAlgorithms;

class LCS {
    // O(N^2) = O(A*B)
    public static int LCS(String a, String b) {
        int[][] memo = new int[a.length()+1][b.length()+1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0)
                    memo[i][j] = 0;
                else if (a.charAt(i-1) == b.charAt(j-1))
                    memo[i][j] = 1 + memo[i-1][j-1];
		else
                    memo[i][j] = Math.max(memo[i-1][j] , memo[i][j-1]);
            }
	}
	return memo[a.length()][b.length()];
    }
    
    public static void main(String[] args) throws Exception {
        String file1 = "hello my name is tyler";
        String file2 = "hi there, tyler is my name";
        System.out.println("Bytes in common: " + LCS(file1 , file2));
    }
}

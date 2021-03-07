package StringAlgorithms;

class BoyerMoore {
    // O(N/K)
    public static void boyerMoore(String a, String b) {
        char[] src = a.toCharArray();
        char[] key = b.toCharArray();
        int[] xChar = new int[256];
        for (int i = 0; i < key.length; i++)
            xChar[key[i]] = i;
        int s = 0;
        while (s <= src.length-key.length) {
            int j = key.length-1;
            while (j >= 0 && key[j] == src[s+j])
                j--;
            if (j < 0) {
                System.out.println("Found it at: " + s);
                s += (s+key.length < src.length) ? key.length-xChar[src[s+key.length]] : 1;
            }
            else 
                s += Math.max(1, j-xChar[src[s+j]]);
        }
    } 

    public static void main(String []args) { 
        String src = "this is a really long string here"; 
        String key = "real";
        boyerMoore(src, key); 
    } 
}
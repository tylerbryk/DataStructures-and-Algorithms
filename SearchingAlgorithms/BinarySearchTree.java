package SearchingAlgorithms;

class BinarySearchTree {
    // O(LogN)
    public static int BST(int[] x, int t, int L, int R) {
        while (L <= R) {
            int mid = (L+R) / 2;
            if (x[mid] > t)
                R = mid - 1;
            else if (x[mid] < t)
                L = mid + 1;
            else
                return mid;
        }
        return -1;
    }
    
    public static int recursiveBST(int[] x, int t, int L, int R) {
        if (L > R) return -1;
        int mid = (L+R) / 2;
        if (x[mid] > t)
            return recursiveBST(x,t,L,mid-1);
        else if (x[mid] < t)
            return recursiveBST(x,t,mid+1,R);
        return mid;
    }
    
    public static void main(String[] args) {
        int[] x = {1,2,4,5,19,20,24,48,52};
        System.out.println(BST(x,52,0,x.length-1)+1 + "th Element!");
    }
}
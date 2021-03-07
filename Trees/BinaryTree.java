package Trees;

class BinaryTree {
    
    private Node root;
    
    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int v) {
            val = v;
            left = null;
            right = null;
        }
        public void inorder() {
            if (left != null)
                left.inorder();
            System.out.print(val);
            if (right != null)
                right.inorder();            
        }
        public void preorder() {
            System.out.print(val);
            if (left != null)
                left.preorder();
            if (right != null)
                right.preorder();            
        }
        public void postorder() {
            if (left != null)
                left.postorder();
            if (right != null)
                right.postorder();   
            System.out.print(val);
        }
    }
    
    public BinaryTree() {
        root = null;
    }
    
    public void add(int v) {
        if (root == null) {
            root = new Node(v);
            return;
        }
        Node p = root;
        while (true)
            if (v < p.val) {
		if (p.left == null) {
                    p.left = new Node(v);
                    return;
		} else
                    p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(v);
                    return;
                } else
                    p = p.right;
            }
    }
    
    public void inorder() {
        if (root != null)
            root.inorder();
    }
    public void preorder() {
        if (root != null)
            root.preorder();
    }
    public void postorder() {
        if (root != null)
            root.postorder();
    }
}

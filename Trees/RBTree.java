package Trees;

class RBTree {
    
    private Node root;
    private static enum Color {RED,BLACK};
    
    private static class Node {
        int val;
        Node parent;
        Node left;
        Node right;
        Color c;
        public Node(int v, Node parent) {
            val = v;
            left = null;
            right = null;
            this.parent = parent;
            c = Color.RED;
        }
        
        public void inorder() {
            if (left != null)
                left.inorder();
            System.out.print(val);
            if (right != null)
                right.inorder();            
        }
    }
    
    public RBTree() {
        root = null;
    }
    
    public void add(int v) {
        if (root == null) {
            root = new Node(v,null);
            return;
        }
        Node p = root;
        while(true)
            if (v < p.val) {
                if (p.left == null) {
                    p.left = new Node(v,p);
                    fixInsert(p.left);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(v,p);
                    fixInsert(p.left);
                    return;
                }
                p = p.right;
            }
    }
    
    private void fixInsert(Node n) {
        if (n.parent == null) {
            n.c = Color.BLACK;
            return;
        } else if (n.parent.c == Color.BLACK)
            return;
        Node p = n.parent;
        Node g = p.parent;
        if (g != null) {
            Node u = g.left == p ? g.right : g.left;
            if (u.c == Color.RED) {
                u.c = Color.BLACK;
                p.c = Color.BLACK;
                g.c = Color.RED;
                fixInsert(g);
            }
        }
    }
    
    public void print() {
        root.inorder();
    }
}

/*

class RBTree {
	
    private static class Node {
	int val;
	Node left;
        Node right;
        Node parent;
	enum Color {RED, BLACK};
	Color c;
	public Node(int v, Node P) {
            val = v; left = null; right = null; parent = P;
            c = Color.RED;
	}
		
        public Node uncle() {
            if (parent == null || parent.parent == null)
                return null;

            if (parent.parent.left == parent)
		return parent.parent.right;
            else
		return parent.parent.left;
	}
		
        public void repair() {
            if (parent == null) // case 1: you are now root
		c = Color.BLACK;
            else if (this.parent.c == Color.BLACK)
		return;
            else {
		Node g = parent.parent; // grandparent
		Node u = uncle();
		if (u != null) {
                    if (u.c == Color.RED) {
			parent.c = Color.BLACK;
			u.c = Color.BLACK;
			g.c = Color.RED;
			g.repair();
                    } else { 
			if (this == parent.parent.left.right) {
                            parent.rotateLeft();
                            this = this.left;
			} else if (this == parent.parent.right.left) {
                            parent.rotateRight();
                            this = this.right; 
			}						
                    }
		}
            }
	}
    }
	
    private Node root;
	
    public RBTree() { root = null; }
	
    public void add(int v) {
	if (root == null) {
            root = new Node(v, null);
            return;
	}
	
        Node p = root;
	while (true)
            if (v < p.val) {
		if (p.left == null) {
                    p.left = new Node(v, p);
                    p.repair();
                    return;
		} else
                    p = p.left;
            } else {
		if (p.right == null) {
                    p.right = new Node(v, null, null, p);
                    p.repair();
                    return;
                } else
                    p = p.right;
            }
    }
}*/
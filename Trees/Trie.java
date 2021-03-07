package Trees;

public class Trie {

    private static Node root;
    
    private static class Node {
        Node[] next;
        boolean isWord;
        public Node() {
            next = new Node[256];
        }
        
        public void print(char[] words, int lvl) {
            if (isWord) {
                for (int i = 0; i < lvl; i++)
                    System.out.print(words[i]);
                System.out.println();
            }
            for (int i = 0; i < 256; i++)
                if (next[i] != null) {
                    words[lvl] = (char)(i);
                    next[i].print(words, lvl+1);
                }
        }
    }
    
    public Trie() {
        root = new Node();
    } 
    
    public void add(String word) {
        char[] words = word.toCharArray();
        Node p = root;
        for (int i = 0; i < words.length; i++) {
            if (p.next[words[i]] == null)
                p.next[words[i]] = new Node();
            p = p.next[words[i]];
        }
        p.isWord = true;
    }
    
    public boolean contains(String word) {
        char[] words = word.toCharArray();
        Node p = root;
        for (int i = 0; i < words.length; i++) {
            if (p.next[words[i]] == null)
                return false;
            p = p.next[words[i]];
        }
        return p.isWord;
    }
    
    public boolean containsPrefix(String word) {
        char[] words = word.toCharArray();
        Node p = root;
        for (int i = 0; i < words.length; i++) {
            if (p.next[words[i]] == null)
                return false;
            p = p.next[words[i]];
        }
        return true;
    }
    
    public void remove(String word) {
        char[] words = word.toCharArray();
        Node p = root;
        for (int i = 0; i < words.length; i++) {
            if (p.next[words[i]] == null)
                return;
            p = p.next[words[i]];
        }
        p.isWord = false;
    }
    
    public void print() {
        char[] words = new char[50];
        root.print(words, 0);
    }    
}
/**
 * @Author Tyler Bryk
 * I pledge my honor that I have abided by the Stevens Honor System
 */
import java.io.*;
import java.util.*;

class TrieHelpers {
    
    private static Trie dictTrie = new Trie();
    private static Trie trie = new Trie();
    private static HashMap dictHash = new HashMap();
    private static HashMap map = new HashMap();
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

        
    public static void add(File file, Trie t, HashMap m) throws Exception {
        Scanner s = new Scanner(file); 
        while (s.hasNext()) {
            String word = s.next();
            t.add(word);
            m.add(word);
        }
        s.close();
    }
    
    public static ArrayList[] contains(File file, Trie t, HashMap m) throws Exception {
        Scanner s = new Scanner(file);
        ArrayList<String>[] cnt = new ArrayList[2];
        cnt[0] = new ArrayList(); cnt[1] = new ArrayList();
        while (s.hasNext()) { 
            String word = s.next();
            if (t.contains(word))
                cnt[0].add(word);
            if (m.contains(word))
                cnt[1].add(word);
        }
        s.close();
        return cnt;
    }
    
    public static ArrayList prefixes(File file, Trie t) throws Exception {
        Scanner s = new Scanner(file);
        ArrayList<String> cnt = new ArrayList<>();
        while (s.hasNext()) { 
            String word = s.next();
            if (t.containsPrefix(word))
                cnt.add(word);
        }
        s.close();
        return cnt;
    }
    
    public static void remove(File file, Trie t, HashMap m) throws Exception {
        Scanner s = new Scanner(file); 
        while (s.hasNext()) {
            String word = s.next();
            t.remove(word);
            m.remove(word);
        }
        s.close();
    }
    
    public static int[] countNonWords(File file, Trie t, HashMap m) throws Exception {
        Scanner s = new Scanner(file); 
        int cnt[] = new int[2];
        while (s.hasNext()) { 
            String word = s.next();
            if (t.contains(word) == false)
                cnt[0]++;
            if (m.contains(word) == false)
                cnt[1]++;
        }
        s.close();
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        try { 
            add(new File("testAdd.txt"), trie, map);
            System.out.println(ANSI_GREEN + "Words successfully added from 'testAdd.txt'" + ANSI_RESET);
            
            System.out.println("\nHistogram of HashMap:");
            map.computeHistogram();
            
            
            ArrayList<String>[] contains = contains(new File("testContains.txt"), trie, map);
            System.out.println("\nTrie Contains: ");
            for (int i = 0; i < contains[0].size(); i++)
                System.out.print(contains[0].get(i) + " ");
            System.out.println("\n\nHash Contains: ");
            for (int i = 0; i < contains[1].size(); i++)
                System.out.print(contains[1].get(i) + " ");
            
            ArrayList<String> prefixes = prefixes(new File("testTriePrefix.txt"), trie);
            System.out.println("\n\nTrie Contains the following Prefixes: ");
            for (int i = 0; i < prefixes.size(); i++)
                System.out.print(prefixes.get(i) + " ");
            
            remove(new File("testRemove.txt"), trie, map); 
            System.out.println("\n\n" + ANSI_GREEN + "Words successfully removed from 'testRemove.txt'" + ANSI_RESET);
            
            System.out.println("\nPrinting contents of the Trie:");
            trie.print();
            System.out.println("\n\nPrinting contents of the HashMap:");
            map.print();
            System.out.println("\n");
        } catch(FileNotFoundException e) { System.out.println(ANSI_RED + "Couldn't find the necessary files!\n" + ANSI_RESET); }

        try {
            add(new File("dict.txt"), dictTrie, dictHash);
            System.out.println(ANSI_GREEN + "Dictionary Successfully Added! " + ANSI_RESET);
            int[] nonwords = countNonWords(new File("prideandprejudice.txt"), dictTrie, dictHash);
            System.out.println("Trie contains " + nonwords[0] + " non-words");
            System.out.println("Hash contains " + nonwords[1] + " non-words");
        } catch(FileNotFoundException e) { System.out.println(ANSI_RED + "Couldn't find 'dict.txt' and/or 'prideandprejudice.txt'\n" + ANSI_RESET); }
    }
}

class HashMap {
    private int size;
    private final int capacity = 500000;
    private LinkedList[] table;
    public HashMap() {
        table = new LinkedList[capacity];
        size = 0;
    }
    private int hash(String val) { return (Math.abs(val.hashCode()) % capacity); }
    public void add(String val) {
	int pos = hash(val);
        if (table[pos] == null) {
            table[pos] = new LinkedList();
            table[pos].addStart(val);
            size++;
            return;
        }
        table[pos].addStart(val);
        size++;
    }
    public void remove(String val) {
        int pos = hash(val);
        if (table[pos] != null) {
            for (int i = 0; i < table[pos].size(); i++)
                if (table[pos].get(i).equals(val)) {
                    table[pos].remove(i);
                    size--;
                }
        }
    }
    public boolean contains(String val) {
        int pos = hash(val);
        if (table[pos] != null) {
            for (int i = 0; i < table[pos].size(); i++)
                if (table[pos].get(i).equals(val))
                    return true;
        }
        return false;
    }
    public int size() { return size; }
    public void print() {
        for (int i = 0; i < capacity; i++)
            if (table[i] != null)
                for (int j = 0; j < table[i].size(); j++)
                    System.out.println(table[i].get(j));
    }
    public void computeHistogram() {
        int[] hist = new int[10];
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null)
                hist[0]++;
            else if (table[i].size() >= 9)
                hist[9]++;
            else
                hist[table[i].size()]++;
        }
        for (int i = 0; i < hist.length; i++)
            if (hist[i] != 0)
                System.out.println("Bin " + i + ": " + hist[i]);
    }
}

class LinkedList {
    private Node head;
    private static class Node {
	public String val;
	public Node next;
    }
    public LinkedList() {
	head = null;
    }
    public void addStart(String v) {
	Node temp = new Node();
	temp.val = v;
	temp.next = head;
	head = temp;
    }
    public String remove(int pos) {
        Node p = head;
        Node q = p.next;
        if (q == null) {
            String v = head.val;
            head = null;
            return v;
        }
        for (int i = 2; i <= pos; i++) {
            p = q;
            q = q.next;
        }
        p.next = q.next;
        return q.val;
    }
    public String get(int pos) {
	Node p = head;
        for (int i = 0; i < pos; i++)
            p = p.next;
        return p.val;
    }
    public int size() {
	int len = 0;
	for (Node p = head; p != null; p = p.next)
            len++;
	return len;
    }
}

class Trie {
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
            for (int i = 0; i < 256; i++) {
                if (next[i] != null) {
                    words[lvl] = (char)(i);
                    next[i].print(words, lvl+1);
                }
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
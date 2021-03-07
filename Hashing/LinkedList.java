package Hashing;

public class LinkedList {
    
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

    public void addEnd(String v) {
	Node temp = new Node();
	temp.val = v;
	temp.next = null;
	if (head == null) {
            head = temp;
            return;
        }
        Node p = head;
	while (p.next != null) 
            p = p.next;
	p.next = temp;
    }

    public void add(int pos, String v) {
	Node p = head;
        for (int i = 0; i < pos; i++)
            p = p.next;
	Node temp = new Node();
	temp.val = v;
	temp.next = p.next;
	p.next = temp;
    }

    public String removeStart() {
	Node temp = head;
	head = head.next;
	return temp.val;
    }

    public String removeEnd() {
	Node p = head;
	Node q = p.next;
	if (q == null) {
            String v = head.val;
            head = null;
            return v;
        }	
	for (; q.next != null; p = q, q = q.next);
	p.next = null;
	return q.val;
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

    public String toString() {
	StringBuilder b = new StringBuilder();
	for (Node p = head; p != null; p = p.next)
            b.append(p.val).append(' ');
	return b.toString();
    }
}
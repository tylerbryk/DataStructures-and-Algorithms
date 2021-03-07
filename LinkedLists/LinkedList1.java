package LinkedLists;

public class LinkedList1 {
    
    private Node head;
    
    private static class Node {
	public int val;
	public Node next;
    }

    public LinkedList1() {
	head = null;
    }
	
    public void addStart(int v) {
	Node temp = new Node();
	temp.val = v;
	temp.next = head;
	head = temp;
    }

    public void addEnd(int v) {
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

    public void add(int pos, int v) {
	Node p = head;
        for (int i = 0; i < pos; i++)
            p = p.next;
	Node temp = new Node();
	temp.val = v;
	temp.next = p.next;
	p.next = temp;
    }

    public void removeStart() {
	if (head == null)
            return;
	if (head.next == null) {
            head = null;
            return;
	}
	head = head.next;
    }

    public void removeEnd() {
        if (head == null)
            return;
	if (head.next == null) {
            head = null;
            return;
	}
        Node f1 = head.next, f2 = head;
        for (; f1.next != null; f2 = f1, f1 = f1.next);
        f2.next = null;
    }
    
    public int remove(int pos) {
        Node p = head;
        Node q = p.next;
        for (int i = 2; i <= pos; i++) {
            p = q;
            q = q.next;
        }
        p.next = q.next;
        return q.val;
    }
    
    public int get(int pos) {
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
package LinkedLists;

public class LinkedList2 {
    
    private Node head, tail;
    
    private static class Node {
	public int val;
	public Node next;
    }

    public LinkedList2() {
	head = null;
        tail = null;
    }
	
    public void addStart(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = head;
        if (head == null)
            tail = temp;
	head = temp;
    }

    public void addEnd(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = null;
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp; 
        tail = tail.next;
    }

    public void removeStart() {
        if (head == null)
            return;
	if (head.next == null) {
            head = tail = null;
            return;
	}
	head = head.next;
    }

    public void removeEnd() {
        if (head == null)
            return;
	if (head.next == null) {
            head = tail = null;
            return;
	}
        Node f1 = head.next, f2 = head;
        for (; f1.next != null; f2 = f1, f1 = f1.next);
        f2.next = null;
        tail = f2;
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
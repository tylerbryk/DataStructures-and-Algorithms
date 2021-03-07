package LinkedLists;

public class DoubleLinkedList1 {
    
    private Node head;
    
    private static class Node {
	private int val;
	private Node next;
	private Node prev;
    }
    
    public DoubleLinkedList1() {
	head = null;
    }
    
    public void addStart(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = head;
        temp.prev = null;
        if (head != null)
            head.prev = temp;
        head = temp;
    }

    public void addEnd(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = null;
	if (head == null) {
            head = temp;
            temp.prev = null;
            return;
        }
        Node p = head;
	while (p.next != null) 
            p = p.next;
	p.next = temp;
        temp.prev = p;
    }

    public void removeStart() {
        if (head == null)
            return;
	if (head.next == null) {
            head = null;
            return;
	}
	head = head.next;
	head.prev = null;
    }

    public void removeEnd() {
        if (head == null)
            return;
	if (head.next == null) {
            head = null;
            return;
	}
        Node f1 = head;
        while (f1.next != null)
            f1 = f1.next;
        f1 = f1.prev;
        f1.next = null;
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
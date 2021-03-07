package LinkedLists;

public class DoubleLinkedList2 {
	
    private Node head, tail;
    
    private static class Node {
	private int val;
	private Node next;
	private Node prev;
    }
    
    public DoubleLinkedList2() {
	head = null;  
        tail = null;
    }
    
    public void addStart(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = head;
	temp.prev = null;
	if (head == null)
            tail = temp;
	else
            head.prev = temp;
        head = temp;
    }

    public void addEnd(int v) {
        Node temp = new Node();
	temp.val = v;
	temp.next = null;
	temp.prev = tail;
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
	head.prev = null;
    }

    public void removeEnd() {
	if (head == null)
            return;
	if (head.next == null) {
            head = tail = null;
            return;
	}
	tail = tail.prev;
	tail.next = null;
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
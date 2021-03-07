package StacksAndQueues;

class Queue {
	
    private LinkedList queue;

    public Queue() { queue = new LinkedList(); }
	
    public void enqueue(int v) { queue.addEnd(v); }
    public int dequeue() { return queue.removeStart(); }
    public boolean isEmpty() { return queue.size() == 0; }
}
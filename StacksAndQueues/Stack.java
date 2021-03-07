package StacksAndQueues;

class Stack {
	
    private int[] stack;
    private int sp;
        
    public Stack(int n) {
	stack = new int[n];
	sp = 0;
    }

    public void push(int v) { stack[sp++] = v; }
    public int pop() { return stack[--sp]; }
    public boolean isEmpty() { return sp == 0; }
}

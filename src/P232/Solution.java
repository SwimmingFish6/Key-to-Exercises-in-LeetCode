class MyQueue {

    LinkedList<Integer> in;
    LinkedList<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.in = new LinkedList<Integer>();
        this.out = new LinkedList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        
        in.push(x);
        
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return in.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return in.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
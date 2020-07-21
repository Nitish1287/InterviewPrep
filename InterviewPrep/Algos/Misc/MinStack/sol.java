
Approach 1: using two inbuilt stacks

Class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> minStack;
    public MinStack() {
        s1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        s1.push(x);
        if(x<=minStack.peek()){
            minStack.push(x);
        }
    }
    
    public int pop() {
        int x = s1.pop();
        if(minStack.peek()==x){
            minStack.pop();
        }
        return x;
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return minStaack.peek();
    }
}
===========================================================
Approach 2: using inbuilt stack and extra variable 'min'
Class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s1;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        s1 = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(x<=min){
            s1.push(min);
            min = x;
        }
        s1.push(x);
    }
    
    public void pop() {
        if(s1.pop().equals(min)){
            min = s1.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

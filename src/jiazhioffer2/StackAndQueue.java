package jiazhioffer2;

import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		StackAndQueue stackAndQueue = new StackAndQueue();
		stackAndQueue.push(1);
		stackAndQueue.push(2);
		stackAndQueue.push(3);
		stackAndQueue.push(4);
		int temp = stackAndQueue.pop();
		
		System.out.println(temp);
	}
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
    		}
    	}
    	if(stack1.isEmpty()) {
    		System.out.println("空");
    	}
    	
    	return stack2.pop() ;
    }

}

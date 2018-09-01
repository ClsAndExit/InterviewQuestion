package jianzhioffer2;

import java.util.Stack;

public class P20_StaticOfMin {
    public static void main(String[] args) {

    }
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()||node<minStack.peek()){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

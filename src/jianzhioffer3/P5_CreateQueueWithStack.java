package jianzhioffer3;

import java.util.Stack;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 21:45
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class P5_CreateQueueWithStack {
    public static void main(String[] args) {
        P5_CreateQueueWithStack p5 = new P5_CreateQueueWithStack();
        p5.push(1);
        p5.push(2);
        p5.push(3);
        p5.push(4);

        System.out.println(p5.pop());
        System.out.println(p5.pop());

        p5.push(5);

        System.out.println(p5.pop());
        System.out.println(p5.pop());
        System.out.println(p5.pop());

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }else {
            System.out.println("null");
        }
        return stack2.pop();
    }
}

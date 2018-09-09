package jianzhioffer3;

import java.util.Stack;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 20:08
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class P20_StackWithMin {
    public static void main(String[] args) {

    }

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void put(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        }
        int topMin = minStack.peek();
        minStack.push(Math.min(topMin, node));
    }

    public static void pop() {
        if (stack.isEmpty()) {
            System.out.println("空");
        } else {
            stack.pop();
            minStack.pop();
        }
    }

    public static int top() {
        if (stack.isEmpty())
            return 0;
        else return stack.peek();
    }

    public static int min() {
        if (minStack.isEmpty())
            return 0;
        else return minStack.peek();
    }
}

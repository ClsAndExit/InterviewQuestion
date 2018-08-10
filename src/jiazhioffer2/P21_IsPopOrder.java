package jiazhioffer2;

import java.util.ArrayList;
import java.util.Stack;

/*
假设入栈的所有数字均不相等
 */
public class P21_IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};

        int[] popA = {4,5,3,2,1};
        int[] popB = {4,3,5,1,2};

        System.out.println(IsOrder(pushA,popB));//false

        System.out.println(IsOrder(pushA,popA));//true
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        //如果长度为0 或者长度不相等
        if(pushA.length == 0||popA.length==0||popA.length!=pushA.length){
            return false;
        }
        int length = pushA.length;
        int popIndex =0 ;
        //辅助栈
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < length; i++) {
            //模拟入栈过程
            stack.push(pushA[i]);
            //模拟出栈过程
            //如果当前栈顶元素等于出栈序列中的  即将出栈的元素 则出栈，并且将出栈序列加1
            //之所以用while不用if是因为可能存在下列情况：栈中的接下来的多个元素恰好与出战序列接下来的即将出栈的元素序
            // 列相同，此时需要连续出栈多个元素，需要持续将popIndex+1
            while (!stack.empty() && stack.peek() == popA[popIndex]){
                stack.pop() ;

                popIndex++;
            }
        }
        //最后如果辅助栈为空，说明这个出栈序列是可行的，若不为空，则说明序列不正确
        return stack.empty();
    }

    public static boolean IsOrder(int [] pushA,int [] popA){
        if(pushA.length == 0||popA.length==0){
            return false;
        }
        int popIndex = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < pushA.length; i++) {
            arrayList.add(pushA[i]);
            while (!arrayList.isEmpty()&&arrayList.get(arrayList.size()-1)== popA[popIndex]){
                arrayList.remove(arrayList.size()-1);

                popIndex++;
            }
        }
        return arrayList.isEmpty();
    }
}

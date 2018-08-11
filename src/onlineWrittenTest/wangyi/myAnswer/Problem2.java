package onlineWrittenTest.wangyi.myAnswer;

import java.util.Scanner;


/**
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 */
public class Problem2 {
    public static void main(String[] args) {

        //*************************完成初始化
        Scanner scan = new Scanner(System.in);
        //一共有多少堆苹果
        int N = scan.nextInt();
        //每一堆苹果有多少个
        int []appleHeap = new int[N];
        for (int i = 0; i < N; i++) {
            appleHeap[i] = scan.nextInt();
        }
        //询问的次数
        int countOFQuestion = scan.nextInt();
        //每一次询问的内容
        int [] questionDegital = new int[countOFQuestion];
        for (int i = 0; i < countOFQuestion; i++) {
            questionDegital[i] = scan.nextInt();
        }
        //*************************初始化完成
        for (int i = 0; i < countOFQuestion; i++) {
            System.out.println(whichheap(appleHeap,questionDegital[i]));
        }
    }

    public static int whichheap(int []appleHeap,int appleID){
        int result = 0;

        for (int i = 0; i < appleHeap.length; i++) {
            appleID -= appleHeap[i];
            if(appleID<=0){
                result =i;
                break;
            }
        }
        return result;
    }
}

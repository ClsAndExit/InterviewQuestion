package onlineWrittenTest.lianjia;

/**
 * @author Mr.Zhang
 * @create 2018-09-04 9:42
 */
public class Count {
    public static void main(String[] args) {
        System.out.println(count(4,5));//3
        System.out.println(count(2,10));//5
    }

    public static int count(int n,int m){
        int count =0;
        while (n != m){
            if (n > m){
                m++;
            }else{
                if(m % 2 == 0){
                    m = m/2;
                }else {
                    m ++;
                }
            }
            count++;
        }
        return count;
    }
}

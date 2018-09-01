package onlineWrittenTest.haoweilai;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 14:35
 * 5.最大上升子序列和
 */
public class Main3 {
    public static void main(String[] args) {
        int[] array = {5, 1, 3, 4, 9, 7, 6, 8};
        //最大升序序列：1，3，4，7，8 result = 23
        int length = array.length;
        int[] b = new int[length];
        int imax = 0;
        for (int i = 0; i < length; i++) {
            b[i] = array[i];
            imax = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    imax = Math.max(imax,b[j]);
                }
            }
            b[i] += imax;
        }
        int max = 0;
        for (int j = 0; j < length; j++) {
            max = Math.max(max,b[j]);
        }
        System.out.println(max);
    }
}

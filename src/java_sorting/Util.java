package java_sorting;

/**
 * @Author Zhang
 * @Date 2018/8/13 8:57
 */
public class Util {
    public static void swap (int[] array,int i,int j){
        int temp = array[i];
        array[i]  =array[j];
        array[j] = temp;
    }
}

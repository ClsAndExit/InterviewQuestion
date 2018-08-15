package searching;

/**
 * @Author Zhang
 * @Date 2018/8/14 10:40
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,0};
        int value = array[7];
        int index = sequenceSearch(array,value);
        System.out.println(index);
    }
    public static int sequenceSearch(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if(array[i]  == value){
                return i;
            }
        }
        return -1;
    }
}

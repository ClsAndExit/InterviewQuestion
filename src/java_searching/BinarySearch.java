package java_searching;

/**
 * @Author Zhang
 * @Date 2018/8/14 11:18
 *
 *  元素必须是有序的，如果是无序的则要先进行排序操作。
 *     折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，
 *     --折半查找能得到不错的效率。但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,0};
        int value = array[7];
        int index1 = binarySearch1(array,value);
        int index2 = binarySearch2(array,value,0,array.length-1);
        System.out.println(index1);
        System.out.println(index2);
    }

    //非递归实现
    public static int binarySearch1(int[] array,int value){
        int low =0;
        int high = array.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if(array[mid] == value){
                return mid;
            }
            if(array[mid] > value){
                high = mid-1;
            }
            if(array[mid] < value){
                low = mid+1;
            }
        }
        return -1;
    }
    //递归实现
    public static int binarySearch2(int[] array,int value,int low,int high){
        int mid = (high+low)/2;
        if(array[mid] == value)
            return mid;
        else if (array[mid] > value)
            return binarySearch2(array,value,low,mid-1);
        else // (array[mid] < value)
            return binarySearch2(array,value,mid+1,high);
    }
}

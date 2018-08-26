package java_searching;

/**
 * @Author Zhang
 * @Date 2018/8/15 8:14
 *
 * 差值查找的基本思想：
 *     二分查找中查找点计算如下：
 *     mid=(low+high)/2, 即mid=low+1/2*(high-low);
 * 　　通过类比，我们可以将查找的点改进为如下：
 * 　　mid=low+(key-a[low])/(a[high]-a[low])*(high-low)，
 * 　　也就是将上述的比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字key，这样也就间接地减少了比较次数。
 * 　　基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。当然，差值查找也属于有序查找。
 */
public class InsertionSearch {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,0};
        int value = array[7];
        int index = insertionSearch(array,value,0,array.length-1);
        System.out.println(index);
    }

    /**
     * 此算法存在一定的风险性
     * 在测试数据 {1,2,3,4,5,6,7,8,9,0};的时候发生java.lang.ArrayIndexOutOfBoundsException异常
     * 在实际的应用中，并不能保证数据一定是严格按照要求的，所以该算法需要慎重使用
     * @param array
     * @param value
     * @param low
     * @param high
     * @return
     */
    public static int insertionSearch(int[] array,int value,int low,int high){
        //相比于二分查找，仅是修改了查找点
        int mid = low+(value-array[low])/(array[high]-array[low])*(high-low);

        if(array[mid] == value)
            return mid;
        else if (array[mid] > value)
            return insertionSearch(array,value,low,mid-1);
        else // (array[mid] < value)
            return insertionSearch(array,value,mid+1,high);
    }
}

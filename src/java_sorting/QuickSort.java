package java_sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Zhang
 * @Date 2018/8/13 8:57
 *
 * 快速排序是不稳定的排序算法
 * 快速排序是冒泡排序的一种改进方法
 * 通过一趟排序将要排序的数据分割成两个独立的部分，其中一部分的所有数据都比另一部分的所有数据都要小（这里通过选取一个基准值来实现），
 * 然后再按照这样的方法分别对两部分数据进行快速排序，整个排序过程可以递归进行，以此实现整个数据是有序序列
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] array = {6,3,5,7,9,2,4,6,8,0};

        quickSort1(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    //快排的递归实现
    public static void quickSort(int[] array,int left,int right){
        if(left<=right){
            //基准数
            int sentinel = array[left];
            //左右两个哨兵
            int low = left;
            int hight = right;
            //停止条件是两个哨兵相遇
            while (low!=hight){
                //先从右开始，找到小于基准数的值
                while (low<hight&&array[hight]>=sentinel){
                    hight--;
                }
                //然后从左开始，找到大于基准数的值
                while (low<hight&&array[low]<=sentinel){
                    low++;
                }
                //将大于基准数和小于基准数的两类数值进行交换
                if(low<hight){
                    Util.swap(array,low,hight);
                }
            }
            //将基准数与左右两边相遇时的数值进行交换
            //这时基准数左右两部分分别是大于基准数和小于基准数的了
            array[left] = array[low];
            array[low] = sentinel;
            quickSort(array,left,low-1);
            quickSort(array,low+1,right);
        }
    }

    //快排的非递归实现
    public static void quickSort1(int s[],int left,int right){
        LinkedHashMap<Integer,Integer> lhp=new LinkedHashMap<>();
        //将0,n放入LinkedHashMap
        lhp.put(left,right);
        while(!lhp.isEmpty()){      //只要有需要排序的段
            //读取left，right
            Iterator<Map.Entry<Integer,Integer>> it=lhp.entrySet().iterator();
            left=it.next().getKey();
            right=lhp.get(left);
            //并从LinkedHashMap中删除
            lhp.remove(left,right);
            if(left>=right)continue;
            int i=left,j=right,temp=s[right];
            while(i<j){         //遍历排序一遍
                while(s[i]<=temp&&i<j)i++;
                if(i<j)s[j--]=s[i];
                while(s[j]>=temp&&i<j)j--;
                if(i<j)s[i++]=s[j];
            }
            s[i]=temp;
            lhp.put(left,i-1);
            lhp.put(i+1,right);
        }
    }
}

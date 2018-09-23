package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/14 9:28
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};
        System.out.println("before heap");
        System.out.println(Arrays.toString(array));

        heapSort(array);

        System.out.println("After heap sort:");
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        if(array == null ||array.length<=1){
            return;
        }

        buildMaxHeap(array);

        for (int i = array.length -1 ; i >= 1 ; i--) {
            Util.swap(array,0,i);

            maxHeap(array,i,0);
        }
    }

    public static void buildMaxHeap(int[] array) {
        if(array == null ||array.length<=1){
            return;
        }

        int half = array.length/2;
        for (int i = half; i >=0 ; i--) {
            maxHeap(array,array.length,i);
        }
    }

    public static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if(left < heapSize && array[left] > array[largest]){
            largest = left;
        }
        if(right < heapSize && array[right] > array[largest]){
            largest = right;
        }

        if(index != largest){
            Util.swap(array,index,largest);
            maxHeap(array,heapSize,largest);
        }
    }
}

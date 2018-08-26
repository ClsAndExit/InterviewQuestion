package java_sorting;

import java.util.Arrays;

/**
 * @Author Zhang
 * @Date 2018/8/14 9:28
 */
public class HeapSort {
    public static void main(String[] args) {
        int heap[]=new int[]{9,8,7,6,5,4,3,2,1};  //把待排序的数存放在数组中
        int n = heap.length;
        heapSort(heap,n);
        System.out.println(Arrays.toString(heap));
    }

    //构建堆算法
    public static void filterHeap(int [] heap,int root,int upper){
        //heep为待筛选的堆，root为堆的根节点，upper为无序区的上界
        //指向孩子节点
        int child ;
        //作为过度变量
        //int item;  //使用了交换函数，不需要用该变量
        //r指向根节点
        int r = root;
        //初始时为根节点的左孩子
        child = 2*root+1;
        while (child<upper){
            //比较左右孩子的关键字值，并取大值
            if(child+1<upper && heap[child+1]>heap[child]){
                child = child+1;
            }
            //若根节点不满足堆的条件，则与孩子交换
            if(heap[r]<heap[child]){
                Util.swap(heap,r,child);
                r = child;
                child = 2*child+1;
            }else
                //若根满足堆的条件，则不交换，并退出筛选
                break;
        }
    }

    public static void heapSort(int[] heap,int n){
        //heap为待排序序列，n为序列长度
        int i;
        //过度变量
        //int item ;//使用了交换函数，不需要用该变量
        //从第一个非页节点开始创建初始堆
        for (i = (n-1)/2; i >0 ; i--) {
            filterHeap(heap,i,n);
        }
        //做n-1趟排序，每次堆的大小减一
        for (i = n-1; i >0 ; i--) {
            //将堆顶元素与当前大根堆的最后一个元素交换
            Util.swap(heap,0,i);

            //筛选，将0~i的元素重新调整
            filterHeap(heap,0,i);

//
//            /*显示排序过程*/
//            for(int j=0;j<n;j++){
//                System.out.print(heap[j]+", ");
//            }
//            System.out.println();
        }
    }
}

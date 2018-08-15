package searching;

import java.util.ArrayList;

/**
 * @Author Zhang
 * @Date 2018/8/15 16:52
 */
public class BlockSearch {
    private int[] index;
    private ArrayList[] lists;

    /**
     * 初始化索引
     *
     * @param index
     */
    public BlockSearch(int[] index) {
        if (index != null && index.length != 0) {
            this.index = index;
            this.lists = new ArrayList[index.length];
            for (int i = 0; i < lists.length; i++) {
                //初始化容器
                lists[i] = new ArrayList();
            }
        } else {
            throw new Error("index cannot be null or empty");
        }
    }

    /**
     * 插入索引
     *
     * @param value
     */
    public void insert(int value) {
        int i = binarySearch(value);
        lists[i].add(value);
    }

    /**
     * 二分查找
     * @param value
     * @return
     */
    private int binarySearch(int value) {
        int start = 0, end = index.length;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (index[mid] > value) {
                end = mid - 1;
            } else {
                //如果相等，也插入后面
                start = mid + 1;
            }
        }
        return start;
    }

    /**
     * 查找元素
     * @param data
     * @return
     */
    public boolean search(int data){
        int i= binarySearch(data);
        for (int j = 0; j < lists[i].size(); j++) {
            if(data == (int)lists[i].get(j)){
                System.out.println(String.format("查找元素为第: %d块  " +
                        "第%d个 元素",  i+1,j+1));

                return true;
            }
        }
        return false;
    }

    /**
     * 打印每块的元素
     */
    public void printAll(){
        for (int i = 0; i < lists.length; i++) {
            ArrayList l = lists[i];
            System.out.println("ArrayList["+i+"]:");

            for (int j = 0; j < l.size(); j++) {
                System.out.println(l.get(j)+"    ");
            }
        }
    }

    public static void main(String[] args) {
        int []index={10,20,30};
        BlockSearch blocksearch=new BlockSearch(index);
        blocksearch.insert(1);
        blocksearch.insert(11);
        blocksearch.insert(21);

        blocksearch.insert(2);
        blocksearch.insert(12);
        blocksearch.insert(22);

        blocksearch.insert(5);
        blocksearch.insert(15);
        blocksearch.insert(25);

        blocksearch.printAll();

        System.out.println("查找值15   结果"+blocksearch.search(15));
        System.out.println("查找值29   结果"+blocksearch.search(29));
    }
}

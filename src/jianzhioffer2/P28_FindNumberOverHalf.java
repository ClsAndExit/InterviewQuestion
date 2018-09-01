package jianzhioffer2;

//多数投票问题
//Boyer-Moore Majority Vote Algorithm 多数投票算法
public class P28_FindNumberOverHalf {
    public static void main(String[] args) {
        int [] array = {1,2,2,2,2,2,3,4,54,5,2,2,2,2,2,2,566};
        int num = MoreThanHalfNum_Solution(array);
        System.out.println(num);
    }

    //如果数组中存在majority那么，、
    // majority的数量一定大于n/2,那么在前i个元素中如果count==0说明没有
    //majority或者majority的数量小于i/2，
    //所以在接下来的(n-i)个元素中，majority的数量一定大于(n-i)/2
    public static int MoreThanHalfNum_Solution(int [] array) {
        int count = 0;
        //最容易实现就是使用HashMap
        int majority = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] == majority){
                count++;
            }else {
                count--;
            }
            if(count == 0){
                majority = array[i];
                count =1;
            }
        }

        count =0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == majority){
                count++;
            }
        }
        return count>array.length/2?majority:0;
    }
}

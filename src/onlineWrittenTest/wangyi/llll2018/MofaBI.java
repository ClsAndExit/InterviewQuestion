package onlineWrittenTest.wangyi.llll2018;

//判断当前的数量是由哪一步得来的，会退回去即可
public class MofaBI {
    public static void main(String[] args) {
        //最大不能超过的数量
        final int MAXN = 100;
        //总共需要魔法币的数量
        int n = 100;
        //记录每一步
        int [] buzhou = new int[MAXN];
        int index = 0;//作为上面数组的游标

        while (n>=0){
            if(n%2 == 0){
                buzhou[index++] = 2;
                n = (n-2)/2;
            }else {
                buzhou[index++] = 1;
                n = (n-1)/2;
            }
        }

        for (int i = index; i >0; i--) {
            System.out.println(buzhou[i]);
        }
    }
}

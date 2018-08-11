package onlineWrittenTest.wangyi.llll2018;

/**
 * 倒过来与原数相加一遍即可
 */
public class XiangFanShu {
    public static void main(String[] args) {
        //如果相加后有进位的情况出现怎么办，不需要考虑吗
        int orginalNumber = 21352;
        int reorderNumber = 0;
        int tempNumber = orginalNumber;
        while (tempNumber != 0){
            reorderNumber = 10*reorderNumber+(tempNumber%10);
            tempNumber = tempNumber/10;
        }
        System.out.println(reorderNumber);
        System.out.println(reorderNumber+orginalNumber);
    }
}

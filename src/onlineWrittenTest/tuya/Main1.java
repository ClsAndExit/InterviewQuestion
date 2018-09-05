package onlineWrittenTest.tuya;

/**
 * @author Mr.Zhang
 * @create 2018-09-05 12:16
 */
public class Main1 {
    public static void main(String[] args) {
        String address1 = "1.2.3.4";
        String address2 = "1.2.3.4.5";
        String address3 = "123.456.78.90";
        String address4 = "255.255.255.255";
        String address5 = "0.0.0.0";
        String address6 = "123.045.067.089";

        System.out.println(validate(address1));
        System.out.println(validate(address2));
        System.out.println(validate(address3));
        System.out.println(validate(address4));
        System.out.println(validate(address5));
        System.out.println(validate(address6));

    }

    /**
     * 验证合法的IPv4地址
     * 是否为4个分段
     * 每个分段是否为合法数字
     * 每个合法数字是否在（0~255）的范围里面
     * @param address
     * @return
     */
    public static boolean validate(String address){
        boolean legal = true;
        String[] segments = address.split("\\.");

        //判断是否分为4段
        if (segments.length != 4){
            return false;
        }
        //判断每一个地址段是否为合法数字
        for (int i = 0; i < segments.length; i++) {
            legal = legalNum(segments[i]);
            if (legal == false){
                return false;
            }else {
                //判断数字是否在范围内
                legal = inRange(segments[i]);
                if (legal == false){
                    return legal;
                }
            }
        }
        return legal;
    }

    public static boolean inRange(String str){
        int num = Integer.valueOf(str);
        if (num>=0 && num <=255){
            return true;
        }
        return false;
    }
    public static boolean legalNum(String str){
        boolean flag = false;
        if (str == null || str.length()<=0){
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i]<='9'){
                flag = true;
            }else {
                return false;
            }
            if (i != 0 && chars[0] == '0'){
                return false;
            }
        }
        return flag;
    }
}

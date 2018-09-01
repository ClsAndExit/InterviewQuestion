package Util;

/**
 * @author Mr.Zhang
 * @create 2018-09-01 14:13
 */
public class IntAndBytes {

    /**
     * 高位在前，低位在后
     *
     * @param num
     * @return
     */
    public static byte[] int2bytes(int num) {
        byte[] result = new byte[4];
        result[0] = (byte) ((num >>> 24) & 0xFF);
        result[1] = (byte) ((num >>> 16) & 0xFF);
        result[2] = (byte) ((num >>> 8) & 0xFF);
        result[3] = (byte) ((num >>> 0) & 0xFF);
        return result;
    }

    /**
     * 高位在前，低位在后
     *
     * @param bytes
     * @return
     */
    public static int bytes2int(byte[] bytes) {
        int result = 0;
        if (bytes.length == 4) {
            int a1 = (bytes[0] & 0xFF) << 24;
            int a2 = (bytes[1] & 0xFF) << 16;
            int a3 = (bytes[2] & 0xFF) << 8;
            int a4 = (bytes[3] & 0xFF) << 0;
            result = a1 | a2 | a3 | a4;
        }
        return result;
    }
}

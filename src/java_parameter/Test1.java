package java_parameter;

import java.lang.reflect.Field;

/**
 * @author Mr.Zhang
 * @create 2018-09-22 20:48
 */
public class Test1 {
    public static void main(String[] args) {
        Integer numa = 1;
        Integer numb = 2;
        System.out.println("numa = " + numa + " , numb = " + numb);// 1 2
        Integer temp = numa;
        numa = numb;
        numb = temp;
        System.out.println("numa = " + numa + " , numb = " + numb);//2 1
        swap3(numa, numb);//1 2
        System.out.println("numa = " + numa + " , numb = " + numb);//2 1


        int a =3;
        int b =4;
        System.out.println("a = "+ a+" , b = "+ b);//3 4
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = "+ a+" , b = "+ b);//4 3
        swap2(a,b);//3 4
        System.out.println("a = "+ a+" , b = "+ b);//4 3
    }
    public static void swap3(Integer numa, Integer numb) {
        int tmp = numa.intValue();
        try{
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(numa,numb);
            field.set(numb,new Integer(tmp));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("numa = " + numa + " , numb = " + numb);//2 1
    }

    public static void swap1(Integer numa, Integer numb) {
        Integer temp = numa;
        numa = numb;
        numb = temp;
        System.out.println("numa = " + numa + " , numb = " + numb);
    }


    public static void swap2(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = " + a + " , b = " + b);
    }
}

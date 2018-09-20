package java_reflection;

import java.lang.reflect.Method;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 19:16
 * <p>
 * 获取成员方法并调用：
 * <p>
 * 1.批量的：
 * public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * public Method getMethod(String name,Class<?>... parameterTypes):
 * 参数：
 * name : 方法名；
 * Class ... : 形参的Class类型对象
 * public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 * <p>
 * 调用方法：
 * Method --> public Object invoke(Object obj,Object... args):
 * 参数说明：
 * obj : 要调用方法的对象；
 * args:调用方式时所传递的实参；
 */
public class MethodClass {
    public static void main(String[] args) throws Exception {
        Class stuclass = Class.forName("java_reflection.Student");

        System.out.println("*****************获取所有“公有”的方法*****************");
        stuclass.getMethods();
        Method[] methodArray = stuclass.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }

        System.out.println("*****************获取所有的方法,包括私有的*****************");
        methodArray = stuclass.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }

        System.out.println("*****************获取所有的show1()方法*****************");
        Method m = stuclass.getDeclaredMethod("show1", String.class);
        System.out.println(m);

        Object obj = stuclass.getConstructor().newInstance();
        m.invoke(obj,"刘德华");

        System.out.println("*****************获取私有的show()4方法*****************");
         m = stuclass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj,20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值"+result);
    }
}

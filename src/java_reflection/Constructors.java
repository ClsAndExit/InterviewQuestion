package java_reflection;

import java.lang.reflect.Constructor;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 19:01
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；

 */
public class Constructors {
    public static void main(String[] args) throws Exception{
        //1、加载class对象
        Class clazz = Class.forName("java_reflection.Student");

        //2、获取所有公有构造方法
        System.out.println("***************所有公有构造方法***************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c:conArray) {
            System.out.println(c);
        }

        System.out.println("***************所有构造方法(包括：私有、保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c:conArray) {
            System.out.println(c);
        }

        System.out.println("***************所有公有、无参的构造方法***************");
        Constructor con = clazz.getConstructor(null);
        System.out.println("con= "+con);

        //newInstance是 Constructor类的方法（管理构造函数的类）
        //它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象。并为之调用
        Object obj = con.newInstance();

        System.out.println("***************获取私有构造方法，并调用***************");
        con = clazz.getDeclaredConstructor(int.class);
        System.out.println(con);

        con.setAccessible(true);
        obj = con.newInstance(12);
    }
}

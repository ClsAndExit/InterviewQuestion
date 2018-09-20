package java_reflection;

import java.lang.reflect.Method;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 19:54
 */
public class Main {
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("java_reflection.Student");

            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null,(Object)new String[]{"1","2","3"});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

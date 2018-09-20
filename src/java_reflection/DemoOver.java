package java_reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 20:17
 *
 * 反射方法的其它使用之---通过反射越过泛型检查
 * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
 *
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 */
public class DemoOver {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strlist = new ArrayList<>();

        strlist.add("aaaaa");
        strlist.add("bbbbb");

        //获取ArrayList的class对象，反向的调用add()方法，添加数据
        Class listClass = strlist.getClass();
        Method m = listClass.getMethod("add", Object.class);
        m.invoke(strlist,100);

        for (Object obj:strlist) {
            System.out.println(obj);
        }
    }
}

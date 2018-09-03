package interviewExperience;

/**
 * @author Mr.Zhang
 * @create 2018-09-03 9:43
 * String.intern() 返回引用的测试
 */
public class RunTimeConstantPoolOOM {
    /**
     * 为什么这个“Java”就是已经存在的了呢？
     * https://segmentfault.com/a/1190000011543995      中解释道：
     * Java虚拟机会自动调用System类
     * 在System类中的注释可以知道，调用了initializeSystemClass方法，在此方法中调用了Version对象的init静态方法
     * sun.misc.Version.init();
     * 因此sun.misc.Version类会在JDK类库的初始化过程中被加载并初始化。
     * 查看Version类定义的私有静态字符串常量如下：
     * private static final String launcher_name = "java";
     * private static final String java_version = "1.7.0_51";
     * private static final String java_runtime_name = "Java(TM) SE Runtime Environment";
     * private static final String java_runtime_version = "1.7.0_51-b13";
     * 在初始化Version类时，对其静态常量字段根据指定的常量值做默认初始化，所以"java"被加载到了字符串常量池中，
     *      修改上面代码使字符串值为上面常量中的任意一个都会返回false。
     * @param args
     */
    public static void main(String[] args) {

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);//true

    }
}

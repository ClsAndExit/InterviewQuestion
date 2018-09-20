package java_reflection;

/**
 * @author Mr.Zhang
 * @create 2018-09-18 8:48
 *
 * 获取class对象的三种方式：
 * 1、object ----  getClass
 * 2、任何数据类型（包括基本数据类型），都有一个静态的class属性
 * 3、通过class类的静态方法：fromName(String  className)（常用）
 */
public class Reflection {
    public static void main(String[] args) {
        //第一种方式获取class对象
        Student stu1 = new Student();
        Class  stuClass = stu1.getClass();
        System.out.println(stuClass.getName());

        //第二种方式获取class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);


        //第三种方式获取class对象
        try{
            Class stuClass3 = Class.forName("java_reflection.Student");
            System.out.println(stuClass2 == stuClass3);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

package java_reflection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 19:58
 *
 * 当我们升级这个系统时，不要Student类，而需要新写一个Student2的类时，
 * 这时只需要更改pro.txt的文件内容就可以了。代码就一点不用改动
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Class stuClass = Class.forName(getValue("className"));
        Method m = stuClass.getMethod(getValue("methodName"));

        m.invoke(stuClass.getConstructor().newInstance());
    }

    public static String getValue(String key) throws IOException{
        Properties pro = new Properties();
        //java项目下的默认路径是项目的根目录
        FileReader in = new FileReader("src/java_reflection/pro.txt");
        pro.load(in);
        in.close();
        return pro.getProperty(key);
    }
}

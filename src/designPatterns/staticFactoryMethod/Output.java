package designPatterns.staticFactoryMethod;

/**
 * @author Mr.Zhang
 * @create 2018-09-08 9:15
 * 详情请查看 InterviewQuestion\src\staticSource\jdkVersionAbout Java8之接口增强.TXT
 */
public interface Output {
    //接口里面定义的属性只能是常量
    int MAX_CACHE_LINE = 50;
    void out();
    void getData(String msg);
}

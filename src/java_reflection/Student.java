package java_reflection;

/**
 * @author Mr.Zhang
 * @create 2018-09-20 18:49
 */
public class Student {
    public void show(){
        System.out.println("IS show()");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行了。。。。");
    }

    /*
    * 成员方法
    *
    * */
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    /*
    * 构造方法
    * */
    Student(String str){
        System.out.println("(默认的)构造方法  s = "+str);
    }

    public Student(){
        System.out.println("调用了公有无参构造方法执行。。。");
    }

    public Student(char name){
        System.out.println("姓名" + name);
    }

    public  Student(String name ,int age){
        System.out.println("姓名："+name+" 年龄"+age);
    }

    protected Student (boolean n){
        System.out.println("受保护的构造方法  n  ="+n);
    }

    private Student(int age){
        System.out.println("私有的构造方法  年龄："+age);
    }
}

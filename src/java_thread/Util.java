package java_thread;

public class Util {
    public static void print(int index, Object object) {
        System.out.println(String.format("%d,%s", index, object.toString()));
    }

    public static void print(Object object) {
        System.out.println(String.format("%s", object.toString()));
    }
}

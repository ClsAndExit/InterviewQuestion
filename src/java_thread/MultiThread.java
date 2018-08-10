package java_thread;


import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 一个Java程序的运行不仅仅是main()方法的运行，而是main线程和许多其他线程同时运行
 *
 * Monitor Ctrl-Break：监听中断信号??这个线程的作用在网上找了好久也没有找到一种满意的解释
 *
 *Attach Listener：该线程是负责接收到外部的命令，执行该命令，并且把结果返回给发送者。通常我们会用一些命令去要求jvm给我们一些反馈信息，如：java -version、jmap、                                     jstack等等。如果该线程在jvm启动的时候没有初始化，那么，则会在用户第一次执行jvm命令时，得到启动。
 *
 * signal dispather： 前面我们提到第一个Attach Listener线程的职责是接收外部jvm命令，当命令接收成功后，会交给signal dispather线程去进行分发到各个不同的模块处理命令，并                                  且返回处理结果。signal dispather线程也是在第一次接收外部jvm命令时，进行初始化工作。
 *
 * Finalizer：  JVM在垃圾收集时会将失去引用的对象包装成Finalizer对象（Reference的实现），并放入ReferenceQueue，由Finalizer线程来处理；最后将该Finalizer对象的引用置为null，由垃圾收集器来回收。
 *
 * Reference Handler ：它主要用于处理引用对象本身（软引用、弱引用、虚引用）的垃圾回收问题。
 *
 * main：主线程，用于执行我们编写的java程序的main方法。
 */
public class MultiThread {
    public static void main(String[] args){
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor信息和synchronized,仅获取线程和线程堆栈信息
        ThreadInfo [] threadInfos = threadMXBean.dumpAllThreads(true,true);
        //遍历线程信息，进打印线程ID和线程名称
        for (ThreadInfo threadInfo:threadInfos
             ) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }
    }
}

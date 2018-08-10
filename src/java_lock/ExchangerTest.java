package java_lock;


import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交
 * 换。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。这两个线程通过
 * exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也
 * 执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产
 * 出来的数据传递给对方。
 * 下面来看一下Exchanger的应用场景。
 * Exchanger可以用于遗传算法，遗传算法里需要选出两个人作为交配对象，这时候会交换
 * 两人的数据，并使用交叉规则得出2个交配结果。Exchanger也可以用于校对工作，比如我们需
 * 要将纸制银行流水通过人工的方式录入成电子银行流水，为了避免错误，采用AB岗两人进行
 * 录入，录入到Excel之后，系统需要加载这两个Excel，并对两个Excel数据进行校对，看看是否
 * 录入一致，
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //A录入银行流水数据
                    String A = "银行流水A";
                    exgr.exchange(A);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String B = "银行流水B";
                    String A = exgr.exchange("B");
                    System.out.println("A和B数据是否一致："+A.equals(B)+".A的录入是：" +
                            A+"，B的录入是："+B);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}

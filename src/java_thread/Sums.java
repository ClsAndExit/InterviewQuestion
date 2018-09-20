package java_thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.Arrays.asList;
/**
 * @author Mr.Zhang
 * @create 2018-09-20 21:53
 */
public class Sums {
    static class Sum implements Callable<Long>{
        private final long from;
        private final long to;
        Sum(long from,long to){
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call(){
            long acc = 0;
            for (long i = from; i < to; i++) {
                acc = acc+i;
            }
            System.out.println(Thread.currentThread().getName()+" : "+ acc);
            return acc;
        }

        public static void main(String[] args) throws Exception{
            ExecutorService executor = Executors.newFixedThreadPool(3);
            List<Future<Long>> result = executor.invokeAll(asList(
                    new Sum(0,10),new Sum(0,1000),new Sum(0,1000000)
            ));
            executor.shutdown();
            for (Future<Long> re :result) {
                System.out.println(re.get());
            }
        }
    }
}

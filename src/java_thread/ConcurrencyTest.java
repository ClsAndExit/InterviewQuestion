package java_thread;

import java_io.Util;

public class ConcurrencyTest {
    private static final long count = 10001;
    public static void main(String [] args){
        concurrency();
        serial();
    }

    private static void concurrency(){
         long start = System.currentTimeMillis();
         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 int a =0;
                 for ( int i = 0; i <count; i++) {
                     a +=5;
                 }
             }
         });
         thread.start();
         int b = 0;
        for (int i = 0; i <count; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Util.print(2,"concurrency :" + time+"ms,b="+b);
    }


    private static void serial(){
        long start = System.currentTimeMillis();
        int a =0;
        for(int i = 0;i<count;i++){
            a+=5;
        }
        int b =0 ;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis()-start;
        Util.print(1,"serial:" + time+"ms,b="+b+",a="+a);
    }
}

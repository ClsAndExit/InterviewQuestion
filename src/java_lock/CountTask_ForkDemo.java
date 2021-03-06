package java_lock;

import java.util.concurrent.*;

public class CountTask_ForkDemo extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2;//阈值
    private  int end;
    private int start;
    public CountTask_ForkDemo(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute(){
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if(canCompute){
            for (int i = start; i <= end; i++) {
                sum+=i;
            }
        }else{
            //如果任务大于阈值，就分裂成两个子任务进行计算
            int middle = (start+end)/2;
            CountTask_ForkDemo leftTask = new CountTask_ForkDemo(start,middle);
            CountTask_ForkDemo rightTask = new CountTask_ForkDemo(middle+1,end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult+rightResult;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask_ForkDemo task = new CountTask_ForkDemo(1,6);
        //执行一个任务
        Future<Integer> result =forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        }catch (InterruptedException e){

        }catch (ExecutionException e){

        }
    }




}

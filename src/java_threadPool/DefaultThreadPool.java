package java_threadPool;

/**
 *客户端可以通过execute(Job)方法将Job提交入线程池执行，而客户端自身不用等待Job的
 * 执行完成。除了execute(Job)方法以外，线程池接口提供了增大/减少工作者线程以及关闭线程
 * 池的方法。这里工作者线程代表着一个重复执行Job的线程，而每个由客户端提交的Job都将进
 * 入到一个工作队列中等待工作者线程的处理。
 *
 *从线程池的实现可以看到，当客户端调用execute(Job)方法时，会不断地向任务列表jobs中
 * 添加Job，而每个工作者线程会不断地从jobs上取出一个Job进行执行，当jobs为空时，工作者线
 * 程进入等待状态。
 *
 * 添加一个Job后，对工作队列jobs调用了其notify()方法，而不是notifyAll()方法，因为能够
 * 确定有工作者线程被唤醒，这时使用notify()方法将会比notifyAll()方法获得更小的开销（避免
 * 将等待队列中的线程全部移动到阻塞队列中）。
 *
 *
 * 线程池的本质就是使用了一个线程安全的工作队列连接工作者线程和客户端
 * 线程，客户端线程将任务放入工作队列后便返回，而工作者线程则不断地从工作队列上取出
 * 工作并执行。当工作队列为空时，所有的工作者线程均等待在工作队列上，当有客户端提交了
 * 一个任务之后会通知任意一个工作者线程，随着大量的任务被提交，更多的工作者线程会被
 * 唤醒。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WOREER_NUMBERS = 10;

    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;

    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;

    //这是一个工作列表，会向里面插入工作
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(
            new ArrayList<Worker>()
    );

    //工作者线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;

    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WOREER_NUMBERS ? MAX_WOREER_NUMBERS : num ;
        workerNum = num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;

        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job){
        if(job != null){
            //添加一个工作，然后进行通知
            synchronized(job){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown(){
        for (Worker worker:workers
             ) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num){
        synchronized(jobs){
            //限制新增的Worker数量不能超过最大值
            if(num + this.workerNum > MAX_WOREER_NUMBERS){
                num = MAX_WOREER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }


    @Override
    public void removeWorker(int num){
        synchronized(jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            //按照给定的数量停止Worker
            int count =0;
            while (count<num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutDown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize(){
        return jobs.size();
    }

    //初始化线程工作者
    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool_Worker_" +
                    threadNum.incrementAndGet());
            thread.start();
        }
    }

    //工作者，负责消费服务
    class Worker implements Runnable{
        //是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    //如果工作者列表时空的，那么就wait
                    while (jobs.isEmpty()){
                        try{
                            jobs.wait();
                        }catch (InterruptedException e){
                            //感知到外部对WorkerThread的终端炒作，返回
                            Thread.currentThread().interrupt();
                            return;
                            //e.printStackTrace();
                        }
                    }
                    //取出一个job
                    job = jobs.removeFirst();
                }
                if(job != null){
                    try{
                        job.run();
                    }catch (Exception e){
                        //e.printStackTrace();
                        //忽略JOB执行中的Exception
                    }
                }
            }
        }

        public void shutDown(){
            running = false;
        }
    }
}

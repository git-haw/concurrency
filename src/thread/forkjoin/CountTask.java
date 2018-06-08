package thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by haw on 18-6-7.
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;//阀值
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canComputer=(end -start)<=THRESHOLD;
        if(canComputer){
            for (int i = start; i <= end; i++) {
                sum+=i;
            }
        }else {
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start+end)/2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle+1,end);
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

    public static Integer count(int start, int end){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(start,end);
        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            return result.get();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (ExecutionException e) {
//            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 7000000;
        long a = System.currentTimeMillis();
        int result = CountTask.count(start,end);
        long b = System.currentTimeMillis();

        long c = System.currentTimeMillis();
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum+=i;
        }
        long d = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("time: "+(b-a));
        System.out.println(sum);
        System.out.println("time: "+(d-c));
    }
}

package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by haw on 18-6-7.
 * 等待多线程完成的CountDownLatch
 * 内部维护了锁计数器，调用await()的线程进入等待状态，
 * 调用countDown()锁计数器减一，直到为0或中断，
 * 才从await()返回继续运行.
 */
public class CountdownLatchTest {
    static CountDownLatch start = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                start.countDown();
                System.out.println(2);
                start.countDown();
            }
        }).start();
        start.await();
        System.out.println(3);
    }
}

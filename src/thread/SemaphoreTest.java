package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by haw on 18-6-8.
 * 控制并发线程数的Semaphore
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 3000;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data ");
                        s.release();
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}

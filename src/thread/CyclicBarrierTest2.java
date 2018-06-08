package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by haw on 18-6-7.
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
//                    e.printStackTrace();
        } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
        }
        System.out.println(2);
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}

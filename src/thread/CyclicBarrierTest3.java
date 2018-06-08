package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by haw on 18-6-7.
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.interrupt();

        try {
            c.await();
        } catch (Exception e){
            System.out.println(c.isBroken());
        }
    }
}

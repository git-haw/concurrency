import thread.util.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by haw on 18-6-5.
 */
public class Interrupted {
    public static void main(String[] args) throws Exception{
        // sleepThread 不停地尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //busyThread 不停地运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        sleepThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());
        //防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){
            }
        }
    }


}

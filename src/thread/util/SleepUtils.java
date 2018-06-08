package thread.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by haw on 18-6-5.
 */
public class SleepUtils {
    public static void second(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

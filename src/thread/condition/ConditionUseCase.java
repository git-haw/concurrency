package thread.condition;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by haw on 18-6-6.
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException{
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }
    public void conditionSignal() throws InterruptedException{
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}

package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by haw on 18-6-6.
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        Lock r = reentrantReadWriteLock.readLock();
        Lock w = reentrantReadWriteLock.writeLock();
        r.lock();
        r.unlock();
        w.lock();
        r.lock();
        w.unlock();
        r.unlock();
    }
}

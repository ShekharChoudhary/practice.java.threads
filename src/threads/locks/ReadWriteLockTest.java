package threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		Lock readLock = new ReentrantReadWriteLock().readLock();
	}
}

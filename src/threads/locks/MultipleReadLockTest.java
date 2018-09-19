package threads.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * Here we can see that multiple read locks can lock a given thread at a given point of time.
 * @author choudshe
 *
 */
public class MultipleReadLockTest {
   
	public static void main(String[] args) {
		boolean state = false;
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock(state);
		Lock readLock = lock.readLock();
		Lock writeLock = lock.writeLock();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Thread t1 = new Thread(new ReadLockTest(readLock, "First"));
		Thread t2 = new Thread(new ReadLockTest(readLock, "Second"));
		Thread t3 = new Thread(new ReadLockTest(readLock, "Third"));
		
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
	}
}


class ReadLockTest implements Runnable{
	
	private Lock lock;
	private String name;
	private String lockType;
	
	public ReadLockTest(Lock lock, String name) {
		this.lock = lock;
		this.name = name;
	}
		
	public void run() {
		try {
		lockType = lock.getClass().getSimpleName();
		System.out.println(name+" Thread "+"is going to have a "+lockType+" lock");
		lock.lock();
		
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println(name+" Thread "+"has released the "+lockType+" lock");
		}
		
	}
	
	
}

package threads.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDowngrading {

	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		/*
		 * here we download the lock by first acquiring the write lock and then downgrading it
		 * to read lock and releasing the write lock.
		 */
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Presently no lock");
				lock.writeLock().lock();
				System.out.println("taken the write lock");
				lock.readLock().lock();
				System.out.println("taken the read lock");
				lock.writeLock().unlock();
				System.out.println("released the write lock and hence downgraded to read lock");
				lock.readLock().unlock();
				System.out.println("read lock released");
			}
		}).start();
		
		/*
		 * making the main thread to sleep so that we can first test the above thread and then 
		 * independently test the below thread.
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**************************************");
		System.out.println("The below example is to test if we can upgrade the lock from read to write");
		System.out.println("****************************************");
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Presently no lock");
				lock.readLock().lock();
				System.out.println("acquired read lock");
				lock.writeLock().tryLock(); // try lock does not wait to get lock
				if(lock.isWriteLocked())
				System.out.println("acquired write lock.");
				lock.readLock().unlock();
				System.out.println("released the read lock");
				// if we do no give this we will get the error java.lang.IllegalMonitorStateException
				if(lock.isWriteLocked()) {
				lock.writeLock().unlock();
				System.out.println("released the write lock");
				}
			}
		}).start();
		
		/*
		 * In this the thread is stuck infinitely because the writer thread does not get lock
		 */
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Presently no lock");
				lock.readLock().lock();
				System.out.println("acquired read lock");
				lock.writeLock().lock();
				System.out.println("acquired write lock.");
				lock.readLock().unlock();
				System.out.println("released the read lock");
				lock.writeLock().unlock();
				System.out.println("released the write lock");
			}
		}).start();
		/*
		 * here we see that the second thread waits infinitely which means that 
		 * lock upgrading is not possible i.e. we cannot switch from read lock to write lock.
		 * 
		 */
	}
}

package threads.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author choudshe
 *
 */
public class ReentrantLocks {

	public static void main(String[] args) throws InterruptedException {
		LockTest test = new LockTest();
		Thread t1 = new Thread(()-> {test.count1();} );
		Thread t2 = new Thread(()-> {test.count2();} );
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		test.show();
	}
}


class LockTest{
	
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	private int count =0;
	
	private void counter() {
		for(int i =0;i<10000;i++) {
			count++;
		}
	}
	
	public void count1() {
		lock.lock();
		try {
			System.out.println("Thread is waiting");
			con.await();
			System.out.println("first thread started");
			counter();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
		lock.unlock();
		}
	}
	
	public void count2() {
		lock.lock();
		try {
			System.out.println("second thread started...");
			Thread.sleep(5000);
			con.signal();
			System.out.println("signal sent by second thread");
			counter();
			Thread.sleep(5000);
			System.out.println("second thread unlocked");
		}  catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		lock.unlock();
		}
	}
	
	public void show() {
		System.out.println("Total count is : "+count);
	}
}

package threads.countDownLatch;

import java.util.concurrent.CountDownLatch;
/** 
 * Here 4 waiter thread will wait until countdown thread completes.
 * Here we put the latch.await() method in waiter thread which we want to wait before 
 * our LatchThread completes.
 * This cannot be reused once it completes.
 * @author choudshe
 *
 */
public class LatchTest1 {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		LatchThreadCountdown countdown = new LatchThreadCountdown(latch);
		LatchThreadWaiter waiter = new LatchThreadWaiter(latch);
		Thread t1 = new Thread(countdown);
		Thread t2 = new Thread(countdown);
		Thread t3 = new Thread(waiter);
		Thread t4 = new Thread(waiter);
		Thread t5 = new Thread(waiter);
		Thread t6 = new Thread(waiter);
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
	}

}


class LatchThreadWaiter implements Runnable {
	
	CountDownLatch latch;
	public LatchThreadWaiter (CountDownLatch latch){
	this.latch = latch;	
	}
 	public void run(){
 		
     System.out.println("Waiter thread waiting.");		
     try {
		this.latch.await();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     System.out.println("Waiter thread released.");
	}
}

class LatchThreadCountdown implements Runnable {
	
	CountDownLatch latch;
	
	public LatchThreadCountdown (CountDownLatch latch){
		this.latch = latch;
	}
 	public void run(){
 		System.out.println("Countdown thread started for "+ Thread.currentThread().getName());
 		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		System.out.println("Countdown thread ended and lock released for "+ Thread.currentThread().getName());
 		this.latch.countDown();
	}
}
package threads.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * Here 3 BarrierThread waits for completion for each other. 
 * But NormalThread completes and it does not wait for other threads.
 * So here we put the method barrier.await() in those threads which has to wait for each other
 * they are called party thread.
 * This can be reused once it completes.
 * @author choudshe
 *
 */
public class BarrierTest {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		Thread t1 = new Thread(new BarrierThread(barrier));
		Thread t2 = new Thread(new BarrierThread(barrier));
		Thread t3 = new Thread(new BarrierThread(barrier));
		
		Thread t4 = new Thread(new NormalThread());
		Thread t5 = new Thread(new NormalThread());
		Thread t6 = new Thread(new NormalThread());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
	
}

class BarrierThread implements Runnable{
	
	CyclicBarrier barrier ;
	public BarrierThread (CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	public void run() {
		System.out.println("Thread parties started" +Thread.currentThread().getName());
		
		try {
			barrier.await();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread parties ended"+Thread.currentThread().getName());
	}
}

class NormalThread implements Runnable{

		
	public void run() {
		System.out.println("Normal thread started" +Thread.currentThread().getName());
		
		System.out.println("Normal thread ended"+Thread.currentThread().getName());
	}

}

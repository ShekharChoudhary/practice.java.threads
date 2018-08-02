package threads.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore is a record of the number of units of a particular resource are available. The resources wait until a unit of the
 * resource becomes available.
 * Semaphores tracks only how many resources are free, it does not keep track of which of the resources are free.
 * Producer consumer problem can be easily implemented with the help of Semaphores.
 * 
 * Semaphores maintains a set of permits.
 * acquire() --> if a permit is available then take it.
 * release() --> adds a permit.
 * 
 * Semaphores just keeps a count of the number available.
 * new Semaphore(int permits, boolean fair)
 * 
 * @author choudshe
 *
 */

enum Downloader {
	
	INSTANCE;
	
	private Semaphore semaphore = new Semaphore(3, true);
	
	public void downloader() {
	
		try {
			semaphore.acquire();
			System.out.println("Downloading the resource from thread :"+ Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		
		semaphore.release();
		}
		
	}
	
}
public class App {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i =0;i<10;i++) {
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				Downloader.INSTANCE.downloader();
				
			}
		});
		}
		executor.shutdown();
	}
	

}

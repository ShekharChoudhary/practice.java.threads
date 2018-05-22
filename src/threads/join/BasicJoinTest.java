package threads.join;

public class BasicJoinTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5;i++){
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*
 * here the code t2.start() will only be called when t1 completes. 
 * in the above line we called t1.join() so the main thread will be
 * executed only after t1 thread completes so at main thread will not move
 * after line number 50 till thread t1 completes.		
 */
		t2.start();
	}
}

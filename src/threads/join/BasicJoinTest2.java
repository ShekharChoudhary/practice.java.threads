package threads.join;

public class BasicJoinTest2 {

	/* Here if we want thread t1 to complete first and then thread t2 to run then we will have to call
	 * t1.join() inside the run method of t2.
	 * 
	 * in our example below main thread and t1 thread will run in parallel but t2 will run after t1 thread.
	 * 
	 */
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
				try {
					t1.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		t2.start();
	}
}

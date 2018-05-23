package threads.join;

public class BasicJoinTest1 {

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
		t2.start();
		try {
/*
 * here the main method will executed till line 46 i.e. till the code t1.join() and then it will stop.
 * the scheduler might call the main thread for execution but it will not proceed from line 47 till thread
 * t1 completes. 
 * one t1 is completed then line 50 of main thread runs once main is called by scheduler. here also main
 * threads stops till thread t2 completes. 
 * 
 * However thread t1 and t2 will run independently.
 * 
 */
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main thread ended");
		
	}
}

package threads.busyspining;

/**
 *  
	Busy spinning or busy wait in a multi-threaded environment is a technique where other threads 
	loop continuously waiting for a thread to complete its task and signal them to start.
 *  Impact of Busy Spinning on performance
	Busy spinning is wasteful of CPU cycles as thread just keep running in a loop unless the condition given in the loop satisfies. 
	The main thing to note here is thread doesn't relinquish the CPU control as would be the case if wait(), sleep(), yield() methods 
	are used where the thread gives up the CPU.
	Busy spinning may give some advantage in multi-core processors. If a thread relinquishes CPU, the CPU cache for the 
	thread where the thread state, data are stored will also be lost, if the thread resumes its operation on another CPU. 
	In that case it has to rebuild the cache again.
	Since thread doesn't relinquish control over CPU when busy spinning so the time spent to create cache again is saved.
 *
 */

public class BusySpiningDemo {
	
	public static void main(String[] args) {
		
		ProducerThread pt = new ProducerThread();
		Thread t1 = new Thread(pt, "Producer");
		Thread t2  = new Thread(new ConsumerThread(pt), "Consumer");
		t1.start();
		t2.start();
	}
	
	

}

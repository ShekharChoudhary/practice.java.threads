package threads.basics;

public class TestSynchronization {

	static Locking lock = new Locking();
	
	public static void main(String[] args) {
		
	Thread t1 = new Thread(()->{
		synchronized (lock) {
			System.out.println("Currently the object is locked");
			for(int i =0;i<10;i++){
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("The lock is released.");
	});	
	
	Thread t2 = new Thread(()->lock.test());
		t1.start();
		t2.start();
	}
}

class Locking {
	
	
	public void test(){
		for(int i=0;i<10;i++){
		try {
			System.out.println("Currently in "+Thread.currentThread().getName());
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}

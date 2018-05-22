package threads.yield;

public class YieldTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<5;i++){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}

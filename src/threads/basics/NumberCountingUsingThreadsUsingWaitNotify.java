package threads.basics;

public class NumberCountingUsingThreadsUsingWaitNotify {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner());
		t1.setName("threadOne");
		Thread t2 = new Thread(new Runner());
		t2.setName("threadTwo");
		Thread t3 = new Thread(new Runner());
		t3.setName("threadThree");
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}

class Runner implements Runnable{

	int counter=1;
	int threadSelection=1;
	
	@Override
	public void run() {

		while(true){
			if(Thread.currentThread().getName().equalsIgnoreCase("threadOne") && threadSelection==1){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection++;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Thread.currentThread().getName().equalsIgnoreCase("threadTwo") && threadSelection==2){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection++;
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Thread.currentThread().getName().equalsIgnoreCase("threadThree") && threadSelection==3){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection=1;
				notifyAll();
			}
		}
	}
	
}

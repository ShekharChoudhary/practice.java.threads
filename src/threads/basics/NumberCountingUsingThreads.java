package threads.basics;

public class NumberCountingUsingThreads {

	static int counter=1;
	static int threadSelection=1;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(()->{
			while(true){
			if(threadSelection==1){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection++;
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		Thread t2 = new Thread(()->{
			while(true){
			if(threadSelection==2){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection++;
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		Thread t3 = new Thread(()->{
			while(true){
			if(threadSelection==3){
				System.out.println(Thread.currentThread().getName()+" : "+counter);
				counter++;
				threadSelection=1;
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}

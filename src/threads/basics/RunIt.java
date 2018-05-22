package threads.basics;

import java.util.StringTokenizer;

class RunIt
{
	public static void main(String[] args) throws InterruptedException
	{
		PhrasePrinter PP = new 	PhrasePrinter();

		Thread T1 = new Thread( new MyClass( PP, "A stitch in time saves nine." ), "T1"  );	
		Thread T2 = new Thread( new MyClass( PP, "Give a camel an inch and he will take an ell." ), "T2" );	

		T1.start();
		T2.start();

		T1.join();		// throws InterruptedException
		T2.join();		// throws InterruptedException

		System.out.println("Main exitting()");
	}
}

class PhrasePrinter
{
	synchronized public void printPhrase( String sPhrase ) {

		sPhrase=sPhrase.trim();

		System.out.print("[ ");

		StringTokenizer st = new StringTokenizer( sPhrase, " " );
		String sWord;
		while ( st.hasMoreTokens() )
		{
			sWord = st.nextToken();
			System.out.print( sWord + "-" );
			try
			{
				Thread.sleep(50);
			}
			catch (InterruptedException e) { }
		}
		System.out.println("]");
	}
}

class MyClass implements Runnable
{	
	private String sPhraseToPrint;
	private PhrasePrinter PP;

	MyClass( PhrasePrinter printer, String s) { 
		PP = printer;
		sPhraseToPrint=s; 
	}

	public void run() {
		PP.printPhrase( sPhraseToPrint );
	}
}

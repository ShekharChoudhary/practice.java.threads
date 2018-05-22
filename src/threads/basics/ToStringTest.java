package threads.basics;

public class ToStringTest {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		System.out.println(e1.x == e2.x);
		System.out.println(e1.y==e2.y);
	}
}


class Employee{

	String x = new String();
	static String y = new String();
	public Employee(){
	}
	
}
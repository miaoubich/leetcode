package net.miaoubich.hackerrank;

public class SubClass extends SuperClass implements SomeInterface{

	public static void main(String[] args) {
		SubClass sb = new SubClass();
		sb.method1();
		SomeInterface.method2();

	}

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub
		
	}
	
	public void method3() {
		System.out.println("This is from SubClass.");
	}

}

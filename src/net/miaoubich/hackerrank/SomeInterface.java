package net.miaoubich.hackerrank;

public interface SomeInterface {

	default void method1() {
		System.out.println("I am a default method!");
	}
	
	static void method2() {
		System.out.println("I'm static.");
	}
}

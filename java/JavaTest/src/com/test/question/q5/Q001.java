package com.test.question.q5;

public class Q001 {
	
	public static void main(String[] args) {
		sum(10);
		sum(10,20);
		sum(10,20,30);
	}//main
	public static void sum(int a) {
		System.out.printf("%d = %d \n", a , a);

	}
	public static void sum(int a,int b) {
		System.out.printf("%d + %d = %d \n", a , b, a);

	}
	
	public static void sum(int a,int b, int c ) {
		System.out.printf("%d + %d + %d = %d \n", a , b, c, a);

	}
	
	
	
}

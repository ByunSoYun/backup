package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번쨰 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번쨰 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		
		int result;
		double result1;
		result = add(n1,n2);
		System.out.printf("%d + %d = %d \n", n1,n2,result);
		
	
		result = add(n1,n1);
		System.out.printf("%d + %d = %d \n", n1,n1,result);
		
		result = subtract(n1,n2);
		System.out.printf("%d - %d = %d \n", n1,n2 ,result);

		
		result = multiply(n1,n2);
		System.out.printf("%d * %d = %d \n", n1,n2 ,result);

		result = multiply(n1,n1);
		System.out.printf("%d * %d = %d \n", n1,n1 ,result);

		result1 = divide(n1,n2);
		System.out.printf("%d / %d = %.1f \n", n1,n2,result1);
	
		result =mod(n1,n2);
		System.out.printf("%d %% %d = %d\n", n1,n2,result);
		
	}//main

	
	
	public static int add (int a, int b) {
		return a + b ;
	}
	
	
	
	public static int subtract (int a, int b) {
		return a - b;

	}

	public static int multiply (int a, int b) {
		return a * b;
	
	}

	public static double divide(double a, double b) {
		return a/b;
	}

	public static int mod (int a, int b) {
		return a%b;
	}

}

package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("첫번쨰 숫자 : ");

		int n1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번쨰 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		
		
		System.out.println( n1 + " + " + n2 +  " = " + add (n1,n2)+" //add(n1,n2)");
		System.out.println( n1 + " + " + n1 + " = " + add (n1,n1)+" //add(n1,n1)");
		System.out.println( n1 + " - " + n2 + " = " + subtract (n1,n2)+" //subtract(n1,n2)");
		System.out.println( n1 + " * " + n2 + " = " + subtract (n1,n2)+" //subtract(n1,n2)");
		
		 

		
		
	}//main
	
	public static int add (int a,int b) {
		
		return  a + b; 
	}
	
	public static int subtract (int a, int b) {
		return a - b;
	}

}

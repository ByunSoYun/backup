package com.test.question.q13;

public class Q012 {
	public static void main(String[] args) {

		int sum = 0;
		String txt = "";
		
		for (int i=2; i<=100; i++) {
			
			sum = 0;
			
			txt = "[";
			
			for (int j=1; j<i; j++) {
				if (i % j == 0) {
					sum += j;
					txt += j + ", ";
				}
			}
			txt += "\b\b]";
			
			if (i == sum) {
				System.out.printf("%d = %s\n", i, txt);
				
			}
			
			
		}
		
		System.out.println("\b\b");
		

	}

}

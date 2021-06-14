package com.test.question.q13;

public class Q008 {
	
	public static void main(String[] args) {
		
		//아래와 같이 출력하시오..
		for (int i=10; i<=100; i+=10) {
			
			int sum = 0;
			
			for (int j=i-9; j<=i; j++) {
				sum+= j;
			}
			
			System.out.printf("%3d ~ %3d : %4d\n",i-9, i, sum);
			
		}
		System.out.println();
		

	}

}

package com.test.question.q13;

public class Q009 {
	public static void main(String[] args) {
		int sum = 0;
		int n =1;
		
		for(int i=1; ; i++) {
				
			if(n>100) {
				break;
				
			}
			
			System.out.printf("%d +", n);
			 sum += n;
			n += i;

		}
		
		System.out.printf("\b\b\b = %d\n", sum);
	}
	

}

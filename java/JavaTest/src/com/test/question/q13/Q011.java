package com.test.question.q13;

public class Q011 {      
	
	public static void main(String[] args) {
		int j =0;
		for(int i =2 ; i<100 ; i++) {
			for(j =2; j<100 ; j++) {
				if(i%j==0) {
					break;
				}
			
			}
			
			if(i==j) {
				  System.out.printf("%d, ", i);      
			}
				
			
		}
		System.out.print("\b\b");

	} 
}

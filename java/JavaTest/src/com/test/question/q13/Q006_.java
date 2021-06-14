package com.test.question.q13;

public class Q006_ {
	public static void main(String[] args) {
		for (int i=1; i<10; i++) {
			for(int j=2; j<6; j++) {
				System.out.printf("%dx%d=%d\t",j,i,j*i);
			}
			System.out.println();
			
			
		}
		
		System.out.println();
		for (int i=1; i<10; i++) {
		for(int j=6; j<10; j++) {
			System.out.printf("%dx%d=%d\t",j,i,j*i);
		}
		System.out.println();
		}
	}//main

}

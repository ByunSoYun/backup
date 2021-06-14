package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int i = Integer.parseInt(reader.readLine());
		
		System.out.print("열 : ");
		int j = Integer.parseInt(reader.readLine());
		
		
		int [][] num = new int [i][j];
		
		int n =1;
		
		for(i=0; i<num.length ; i++ ) {
			for(j=0; j<num[0].length-i; j++) {
				num[i][j]=n;
						
						n++;
			}
		}
		
	
		output(num);
		
	}//main
	
	private static void output(int [][] num) {
		for(int i=0; i<num.length; i++) {
			for (int j=0; j<num[0].length; j++) {
				System.out.printf("%3d",num[i][j]);
			}
			System.out.println();
		
		}System.out.println();
	}

}

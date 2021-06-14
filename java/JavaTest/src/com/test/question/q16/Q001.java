package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int i = Integer.parseInt(reader.readLine());
		
		System.out.print("열 : ");
		int j = Integer.parseInt(reader.readLine());
		
		
		int [][] num = new int [i][j];
		
		int n =1; //n 값 초기화 
		for(i=0; i<num.length; i++) {  
			
			if(i%2==0) {
				for(j=0; j<num[0].length; j++) {
			
				num[i][j] = n;
				n++;
				
				}
			}else {
		
			for(j=num[0].length-1; j>=0; j--) {
				num[i][j] = n;
				n++;
				}
		
			
			}//else
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

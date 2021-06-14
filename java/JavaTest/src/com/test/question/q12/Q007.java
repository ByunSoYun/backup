package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("루프를 종료할 누적값: ");
		int end = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for(int i = 1; ; i++) {
			  
			sum+=i;
			
			if(sum >= end) {
			System.out.printf("%d = %d",i, sum);
				break;
			}else {        
				System.out.printf("%d + ",i );            
	        
				
			}
	
		}//for  
		

		
	}//main

}

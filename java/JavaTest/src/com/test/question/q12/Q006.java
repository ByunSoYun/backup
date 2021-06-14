package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int startnum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자: ");
		int endnum = Integer.parseInt(reader.readLine());
		
		int Oddsum = 0;
		int Evensum = 0;
	
		for(int i = startnum; i<= endnum; i++ ) {
			if (i ==1 ) {
				Oddsum += i;
			System.out.printf("%d",i);
			}else if (i%2==1) {
				Oddsum += i;
				System.out.printf("+%d",i);
				
			} else {
				Evensum -= i;
				System.out.printf("-%d",i);
				
			}
		}
		
		System.out.printf("=%d",Evensum+Oddsum);
		
	}//main

}

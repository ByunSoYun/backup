package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q014 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("9자리 숫자 입력 :");
		int num = Integer.parseInt(reader.readLine());
		

		for (int i =1 ;i<10; i++) {
			if(num%2==0) {//첫째자리 숫자= 짝수
				
			}//if
		
		}//for
		
	}//main
}

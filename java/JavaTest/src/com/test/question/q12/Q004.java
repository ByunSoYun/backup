package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int Evensum = 0;
		int Oddsum = 0;
		int i = 0;
		
		
		System.out.print("입력받을 숫자의 갯수: ");
		int inputnum = Integer.parseInt(reader.readLine());
		
		
		for(i =1; i<=inputnum ; i++) {
			
			System.out.print("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			if(num%2==0) { 
				int Even = num;		// Even 변수선언안하고 num을 넣어도됨
				Evensum += Even; 
			}else {
				int Odd = num;      // Odd 변수선언안하고 num을 넣어도됨
				Oddsum += Odd;
				}
			
			
		}//for

		
		System.out.printf("짝수의 합: %,d\n", Evensum);
		System.out.printf("홀수의 합: %,d\n", Oddsum);
		
	}

}

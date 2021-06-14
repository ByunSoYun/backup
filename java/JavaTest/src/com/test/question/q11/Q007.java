package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("숫자입력:");
		int num1 = Integer.parseInt(reader.readLine()); 
	
		System.out.print("숫자입력:");
		int num2 = Integer.parseInt(reader.readLine()); 
	
		System.out.print("숫자입력:");
		int num3 = Integer.parseInt(reader.readLine()); 
	
		System.out.print("숫자입력:");
		int num4 = Integer.parseInt(reader.readLine()); 
	
		System.out.print("숫자입력:");
		int num5 = Integer.parseInt(reader.readLine()); 
			
		int Even =0;
		int Odd = 0;
		
	if  ( num1 > 0 &&  num2 > 0 &&  num3 > 0 &&  num4 > 0 &&  num5 > 0 && num1 <= 10 && num2 <= 10 && num3 <= 10 && num4 <= 10 && num5 <= 10)  {
			
			if(num1 % 2==0) {
			 Even = 1; Odd = 0;
			} else { 
			Even = 0; Odd = 1; 
			}
				 
				if(num2 % 2 == 0) {
					Even= Even +1; 
				} else {
					Odd = Odd + 1 ;
				}
				
					if(num3 % 2 == 0) {
						Even= Even +1; 
					} else {
						Odd = Odd + 1 ;
					}
					
						if(num4 % 2 == 0) {
							Even= Even +1; 
						} else {
							Odd = Odd + 1 ;
						}
					

							if(num5 % 2 == 0) {
								Even= Even +1; 
							} else {
								Odd = Odd + 1 ;
							}
	}//if 첫구문 
	
	System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다 \n", Even, Odd);
	
		if (Odd > Even) {
		System.out.println("홀수가 짝수보다" + (Odd-Even)+ "개 많습니다.");
		} else if (Odd < Even) {
		System.out.println("짝수가 홀수보다" + (Even-Odd)+ "개 많습니다.");
		} 
		
	
	}
}

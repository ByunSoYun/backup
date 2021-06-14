package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("루프를 종료할 누적값 : ");
		int endnum = Integer.parseInt(reader.readLine());
		
		
		int EvenSum = 0;
		int OddSum = 0;
		int sum = 0;
		int Even = 0;
		int Odd = 0;
		
		
		for(int i=1; ;i++) {
			System.out.print("숫자 :");
			int num = Integer.parseInt(reader.readLine());
			
			if(num%2==0) {
				Even = num;
				EvenSum += num;
				
			}else {
				Odd = num;
				OddSum -= num;
				
			} //if
			
			sum = EvenSum +OddSum;
			
				if(sum>=endnum) {
					System.out.printf("%d = %d",Even, sum);
					break;
				}else {       
					System.out.printf("+%d ",Even );   
					System.out.printf("-%d ",Odd );
				}
	
			
		}//for
		
		
	}//main

}

        


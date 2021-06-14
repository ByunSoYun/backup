package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		System.out.print("숫자 개수: ");
		int count = Integer.parseInt(reader.readLine());
		
		
		int[] num = new int[count];
		int i;
		
		System.out.print("[");
		
		for (i=0; i<=num.length-1; i++) {
			
			
			num[i] = (int)(Math.random() * (end - start+1) + start);
			
			for(int j=0; j< i; j++) {//조건식이 j<=i가 되면 무한루프로 빠지게됨!
				
				if(num[i] == num[j]) {
					i--;
				break;
				}
			}			
			
		}
		
		
		for(int n: num) {
			System.out.print(n + " ");
		}
		System.out.print("]");
		
		
	}//main

}

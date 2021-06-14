package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {

public static void main(String[] args) throws NumberFormatException, IOException {
		
	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제 위치: ");
		int index = Integer.parseInt(reader.readLine());
		
		int[] list = new int[5];//지정

		for(int i=0; i<list.length; i++) {
			
			list[i]= (int)(Math.random()* 10 + 1);
		}
		
		output(list);
		
		delete(list, index);
		
		output(list);
	
		
	}//main

	
	private static void delete(int[] list, int index) {
	
		for(int i= index; i<list.length-1; i++) {
			list[i]=list[i+1];
		}
		
	}//delete

	public static void output(int[] list) {
		
		for(int i =0; i<list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		
	}//output
	
}//Q008

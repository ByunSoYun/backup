package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	
		System.out.print("태어난 년도: ");
		String year = reader.readLine();
		
		int iyear = Integer.parseInt(year);
		int age = 2021 - iyear + 1 ;
		
		System.out.printf("나이 : %d",age);
		
		
	}

	
	
}

package com.test.question.q10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Calendar;

public class Q003 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("태어난 년도: ");
		int birthYear = Integer.parseInt(reader.readLine());
		
		System.out.printf("나이 : %d", Age() - birthYear +1 );
		
		
	
	}//main

	private static int Age() {
		
		Calendar now = Calendar.getInstance();
		
		
			return now.get(Calendar.YEAR) ;
		
	}

	
}

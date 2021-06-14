package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자:");
		int letter = reader.read(); 
	// char letter = (char) reader.read(); 대체가능
	
		
		if (letter >=97 && letter <= 122) {
			System.out.printf("결과: %c", letter -32 );
		} else if(letter >=65 && letter <= 90) {
			System.out.printf("결과: %c", letter + 32 );
		} else {
			System.out.printf("영문자가 아니다.");
		}
	
	
	
	
	}

}
//소문자가 32 큼 
//대문자 65부터 시작 90까지   
//소문자 97-122 		
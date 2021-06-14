package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 :");
		char letter = (char)reader.read(); 
		
		if (letter == 'b' || letter == 'B') {
			System.out.println("Brother");
		} else if (letter == 'f' || letter == 'F') {
			System.out.println("Father");
		} else if (letter == 'M' || letter == 'm') {
			System.out.println("Mother");
		} else if (letter == 's' || letter == 'S') {
			System.out.println("Sister");
		} else {
			System.out.println();
		}
			
		
		
	}

}
// B = 66  b = 98
// F = 70  f = 102
// M = 79  m = 111
// S = 83  s = 115
//소문자 97-122 			S = 83   s115
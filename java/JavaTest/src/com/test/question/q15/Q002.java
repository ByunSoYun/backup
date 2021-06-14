package com.test.question.q15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학생수: ");
		int studentNum = Integer.parseInt(reader.readLine());
		
		String[] studentNames = new String[studentNum];
	
		
		for(int i=0; i<studentNum; i++) {
		System.out.print("학생명: ");
		String studentName = reader.readLine();
		studentNames[i]= studentName;
		}
		System.out.printf("입력한 학생은 총 %d명입니다\n.",studentNum);
		
		for(int j = studentNum-1; j>=0 ;j--) {
			System.out.printf(" %d.%s \n", studentNum-j,studentNames[j]);
		}
	
	
	}//main

}

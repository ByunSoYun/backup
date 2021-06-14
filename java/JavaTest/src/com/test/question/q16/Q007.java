package com.test.question.q16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어: ");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어: ");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학: ");
		int math = Integer.parseInt(reader.readLine());
	
		String[][] score = new String [10][3];
		
		
		
		for(int i=0; i <score.length; i++) {
			if(i<kor/10) {
				score[9-i][0] = "■";
			}else {
				score[9-i][0] = " ";
			}
			if(i<eng/10) {
				score[9-i][1] = "■";
			}else {
				score[9-i][1] = " ";
			}
			if(i<math/10) {
				score[9-i][2] = "■";
			}else {
				score[9-i][2] = " ";
			}
			
		
		
		
		
		
		
		
		
		
		
		}//for
		
		
		
		
	
		output(score);
	

		System.out.println("-------------------");
		System.out.println("  국어   수학   영어");
		
	}//main
	
	private static void output(String[][] score) {
		for(int i=0; i<score.length; i++) {
			for (int j=0; j<score[0].length; j++) {
				System.out.printf("%5s",score[i][j]);
			}
			System.out.println();
		
		}System.out.println();
	}
	
}//Q007

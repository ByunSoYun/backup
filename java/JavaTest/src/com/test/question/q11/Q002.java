package com.test.question.q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("점수 :");
	int score = Integer.parseInt(reader.readLine());
	
	//유효성 검사 
	if(score>=0 && score <=100) {
			
			if(score >= 90 && score == 100) {
				System.out.printf("입력한 %d은 성적 A입니다", score);
			} else if (score >= 80 && score <90) {
				System.out.printf("입력한 %d은 성적 B입니다", score);
			} else if (score >= 70 && score <80) {
				System.out.printf("입력한 %d은 성적 C입니다", score);
			} else if (score >= 60 && score <70) {
				System.out.printf("입력한 %d은 성적 D입니다", score);
			} else {
				System.out.printf("입력한 %d은 성적 F입니다", score);
			}
		
		}
	
	}
}

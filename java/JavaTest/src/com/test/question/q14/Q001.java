package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장입력: ");
		String txt = reader.readLine();
		for(int i =(txt.length()-1); i >=0 ;i--) { // 자리수가 0부터 시작해서 길이에서 1빼고 조건으로 넣어야함
			System.out.print(txt.charAt(i));
		}
		
	}

}

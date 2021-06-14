package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	
	public static void main(String[] args) throws IOException {
		
		//입력받은 금액을 한글로 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원): ");
		String money = reader.readLine();
		//String money = "53216";
		
		String result = "";
		
		for (int i=0; i<money.length(); i++) {
			
			char c = money.charAt(i);
			
			if (c == '0') {
				result += "영";
			} else if (c == '1') {
				result += "일";
			} else if (c == '2') {
				result += "이";
			} else if (c == '3') {
				result += "삼";
			} else if (c == '4') {
				result += "사";
			} else if (c == '5') {
				result += "오";
			} else if (c == '6') {
				result += "육";
			} else if (c == '7') {
				result += "칠";
			} else if (c == '8') {
				result += "팔";
			} else if (c == '9') {
				result += "구";
			} else {
				System.out.println("숫자를 다시 입력하시오.");
				break;
			}
			
		}//for
		
		System.out.println(result);
		
		
	}//main

}

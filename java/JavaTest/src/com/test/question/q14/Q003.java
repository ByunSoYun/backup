package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자:");
		String num = reader.readLine();
		int sum =0;
		System.out.print("결과:");
		for(int i=0; i<num.length() ; i++) {
			int j = num.charAt(i);
			sum+=(j-48);
			if (i == (num.length()-1)) {
				System.out.printf("%d",j-48);
			}else {
				System.out.printf("%d +",j-48);
			}
			
		}
	
		System.out.printf("= %d",sum);

		
		
	}

}

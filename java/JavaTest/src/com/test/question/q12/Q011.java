package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("최대 숫자: ");
	int MaxNum = Integer.parseInt(reader.readLine());
	
	for (int i=1 ; i<= MaxNum ; i++) {
		if(MaxNum>999) {
			System.out.println("3자리수 이상 입력 불가");
			break;
			
		}else if(i%3==0) {
			System.out.print("짝 ");
		}else {
			System.out.printf("%d ",i);
		}
		
	}
}
}

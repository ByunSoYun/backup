package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름: ");
		String name = reader.readLine();
		
		for(int i=1; i<=3; i++) {
			System.out.printf("%s님 안녕하세요~\n",name);
		}
		
	
	
	}//main
	

}

//System.out.print("이름: ");

String str = reader.readLine();

System.out.print("횟수: ");

int num = Integer.parseInt(reader.readLine());

int i = 0;

for (i = 1;; i++) {
   
   if (i == num + 1) {
      break;
   }
   
   System.out.printf("%s님 안녕하세요~\n", str);
package com.test.question.q12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q012 { 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		 String output="";

		
		for(int i =1; i<=10; i++) {
			System.out.print("숫자:");
			int num = Integer.parseInt(reader.readLine());
			if (num>=10) {
				System.out.println("두자리 이상 입력하지 마시오.");
				break;
		}    else {
			
			switch(num) {
         case 1: 
            output += "일";
            break;
         case 2: 
            output += "이";
            break;
         case 3: 
            output += "삼";
            break;
         case 4: 
            output += "사";
            break;
         case 5: 
            output += "오";
            break;
         case 6: 
            output += "육";
            break;
         case 7: 
            output += "칠";
            break;
         case 8: 
            output += "팔";
            break;
         case 9: 
            output += "구";
            break;
  
			  
		  }
			
		}
			System.out.printf("결과: %s \n",output);
		}
		
			
	
	
	}//main

}

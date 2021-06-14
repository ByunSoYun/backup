package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {

	public static void main(String[] args) throws IOException {
		
		//영어 단어를 1개 입력받아 아래와 같이 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어: ");
		String word = reader.readLine();
		
		String result = "";
		
		result = word.substring(0, 1);
		
		for (int i=1; i<word.length(); i++) {
			
			char c = word.charAt(i);
			
			if (c >= 'A' && c <= 'Z') {
				result += " " + c;
			} else {
				result += c;
			}
			
		}
		
		System.out.printf("결과: %s\n", result);
		
	}

}




	
	
	//	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.print("단어:");
//		String word = reader.readLine();
//		
//		int index = 0;
//		String str1 = ""; 
//		String str2= "";// 초기화시킴
//		
//		 for(int i=0; i<word.length() ; i++) {
//			if(i >=65 || i<=96) {
//			index = word.indexOf(i);
//			}
//			
//			
//			
//		}	str1 = word.substring(0,index);
//		str2 = word.substring(index);
//		System.out.println(str1 + ' ' + str2);
//			
//	}//main
//
//}

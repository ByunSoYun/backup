package com.test.question.q14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {public static void main(String[] args) throws IOException {
	
	//금지어를 마스킹 처리 하시오.
	
	int count = 0;
	int index = 0;
	String word1 = "바보";
	String word2 = "멍청이";
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("입력: ");
	String line = reader.readLine();
	
	while (true) {
		index = line.indexOf(word1, index); //1번단어 원하는 곳을 검색한 곳의 위치 
		if (index > -1) {   // 위치가 나옴 -> 존재함 
			count++;    // 금칙어 증가
			index += word1.length();  // 길이 더해줌 
		} else {
			break;
		}
	}
	
	while (true) {
		index = line.indexOf(word2, index);//2번단어 원하는 곳을 검색한 곳의 위치 
		if (index > -1) {
			count++;
			index += word2.length();
		} else {
			break;
		}
	}
	
	System.out.println(line.replace(word1, "**").replace(word2, "***")); //대체-> 마스킹
	System.out.printf("금지어를 %d회 마스킹했습니다.\n", count);
	
}

}
	
	
	
	
	
	

//	public static void main(String[] args) throws IOException {
//		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		 System.out.print("");
//		 String input = reader.readLine();
//		 for( int i = 0 ; ; i++){
//			 if(input.indexOf("바보") == -1) {
//				 System.out.printf();
//			 }
//				 
//		 }
//		
//		 
//	}
//
//}

package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.io.BufferedReader; //자주 안쓰는 걸 창고에서 도구를 가져와 사용하겠습니다 > 클래스 임포트
//import java.io.InputStreamReader;// 자주 안쓰는 클레스 밑에 빨간 줄쳐지면 밑에 import 클릭 
 

//import java.io.*;// *(wild card-all) java.io에 있는 모든것 을 가져옴 -안가져 와도 될것을 같이 가져오기때문에 각각 가져오는게 효율적 즉 위에 두개만 가져오는것 권장

//Ctrl + Shift + O  //***** 아주 자주씀 임포트 안된것을 자동으로 임포트 해줌 


public class Ex10_Input {
	public static void main(String[] args) throws IOException {
		
		//Ex10_Input.java
		
		//BufferedReader 클래스
		
		/*
		 * System.out.print("문자 입력: ");
		 */
		//이클립스 주석 단축키
		//- 단일 주석 : Ctrl + /
		//-  주석 : Ctrl + Shift +/
		//         Ctrl + Shift +\
		
		
//		int a = 10;
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		
		//reader : 키보드 입력 받을 수 있는 도구
		
		//int data = reader.read(); //사용안함
		//System.out.println(data);
	
	
//		String data = reader.readLine();//******입력한 라인 전체를 반환한다 (자료형이 String이다) 
//	    System.out.println(data);

	
		/*
		 * //요구사항] 이름입력 > 인사하시오 System.out.print("이름 입력: ");
		 * 
		 * String name = reader.readLine();
		 * 
		 * 
		 * 
		 * System.out.printf("안녕하세요.%s님\n", name);
		 */
		/*
		 * //요구사항 ] 태어난 년도를
		 * 
		 * 
		 * System.out.print("생년 입력: "); String year = reader.readLine();
		 * 
		 * int iyear = Integer.parseInt(year);//"1995" -> 1995
		 * 
		 * int age = 2021 - iyear;
		 * 
		 * System.out.printf("당신의 나이는 %d세입니다.\n", age);
		 */
		 
	    
	    //2021 - year
	    //2021 - 1995
	    //2021- "1995"
	    //int age = 2021 - year;// The operator - is undefined for 
	    
	    // 문자열 ->(변환)-> 숫자
	    
	    
	   /* "문자열" -> byte : Byte.parseByte("문자열")
	    "문자열" -> short : Short.parseShort("문자열")
	    "문자열" -> int : Integer.parseInt("문자열")
	    "문자열" -> long : Long.parseLong("문자열")
	    "문자열" -> float : Float.parseFloat("문자열")
	    "문자열" -> double : Double.parseDouble("문자열")
	    "문자열" -> boolean : Boolean.parseBoolean("문자열")
	    "문자열" -> char : X
	    "A" -> 'A' : "A"*/
    
	    
	    
		
		  

		 
	    
	    
		
		  //요구사항] 숫자(정수)를 2개 입려받아 > +연산을 하시오.> 연산 과정과 결과를 모두 출력하세요.
		  System.out.printf("첫번째 숫자: ");
		  
		  String data1 = reader.readLine(); int first = Integer.parseInt(data1);
		  
		  System.out.print("두번째 숫자: "); String data2 = reader.readLine(); int second =
		  Integer.parseInt(data2);
		  
		  System.out.printf("%d + %d = %d\n", first,second,first + second);
		 
	}

}

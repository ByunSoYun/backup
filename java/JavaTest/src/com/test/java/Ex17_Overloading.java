package com.test.java;

public class Ex17_Overloading {
	public static void main(String[] args) {
	 	
		//Ex17_Overloading.java
		
		//메소드 오버로딩, Method Overloading
		//- 같은 이름의 메소드를 여러개 만드는 기술 
		//- 메소드가 인자 리스트의 형태를 다양하게 구성해서 동일한 메소드명을 가질 수 있게하는 기술
		//- 프로그램 성능(X), 개발자 도움(O)
		
		//메소드 오버로딩 조건 O
		//1. 인자의 갯수
		//2. 인자의 타입
		
		//메소드 오버로딩 조건X
		//1. 인자의 이름
		//2. 반환값의 타입
		
		// 메소드 선언하는 중..
		//1. public static void test(){} // 존재 O
		//2 public static void test(){}// 존재x 1번떄문
		//3. public static void test(int n){} -> 존재 o 
		//4. public static void test(int m) {} -> 존재 x 3번떄문에 
		//5. public static void test(String s) {} -> 존재 o  
		//6. public static void test(int n, int m) {} -> 존재 o  
		//7. public static void test(int n, String s) {} -> 존재 o  
		//8. public static void test(String n, int s) {} -> 존재 o  
		//9. //3. public static String test(int n){} -> X 3번 떄문 
		
		
		//test();// -매개변수 x
		//test(10); // - 매개변수 o 그래서 두개 같이 존재O  구분될수 있기때무네 
		
}
	public static void test() {
		
		System.out.println("사과");
	}//1
	
	
	//public static void test() {
	 //System.out.println("딸기");
	//}//2 메소드는 똑같은 이름을 가질 수 없다 -> 구분할 수 없다 .
		
	public static void test(int n) {
			
		System.out.println("사과");
		}//3
	
	
//	public static void test(int m) {
//			
//		System.out.println("사과");
//		}4
//		
	
	public static void test(String s){
	}//5
	
	public static void test(int n, int m){
	}//6
	
	
	public static String test(int n) {
		
		System.out.println("사과");
		}
	
	
	
	***
	//3. test(10)
	//9 String result = test(10);
	// 연산자에서 오른쪽부터 확인해서 왼쪽에 대입하는것 즉 test부터 호출대서 3번이랑 구분 안된다.

	
}
